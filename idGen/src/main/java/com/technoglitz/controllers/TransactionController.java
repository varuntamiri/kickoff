package com.technoglitz.controllers;

import static com.technoglitz.standalones.TxnIdGenerator.generateRandom;
import static java.lang.System.currentTimeMillis;
import static java.util.UUID.randomUUID;
import static java.util.concurrent.Executors.newFixedThreadPool;
import static org.apache.commons.lang3.RandomStringUtils.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

import org.opensaml.common.impl.RandomIdentifierGenerator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {
	
	LinkedHashMap<Integer, List<Long>> gdata = new LinkedHashMap<>(10);
	AtomicInteger atomicInteger = new AtomicInteger(0);
	@RequestMapping("/resource")
	public Map<String, Object> home()  {
		List<String> labels = new ArrayList<>();
		List<String> uuids = new ArrayList<>();
		List<String> samls = new ArrayList<>();
		List<String> basics = new ArrayList<>();
		List<String> acoms = new ArrayList<>();
		long start = currentTimeMillis();
		Map<String, Object> model = new TreeMap<>();
		RandomIdentifierGenerator identifierGenerator = new RandomIdentifierGenerator();
		int threads = 10000;
		int generations = 100000;
		
		model.put("generates", generations);
		model.put("threads", threads);
		
		long jUuidVal = generateIdTest(newFixedThreadPool(threads), generations, () -> {randomUUID();});
		ResultPair pair = new ResultPair("Java UUID generator", jUuidVal, "thirty two chars length, not customizable");
		long osamlVal = generateIdTest(newFixedThreadPool(threads), generations, () -> {identifierGenerator.generateIdentifier(4);});
		ResultPair pair1 = new ResultPair("Open Saml generator", osamlVal, "length, customizable but alphanumeric");
		long apacheCVal = generateIdTest(newFixedThreadPool(threads), generations, () -> random(7, false, true));
		ResultPair pair2 = new ResultPair("Apache Commons generator", apacheCVal, "length and alpha/numeric or both customizable");
		long basicRaVal = generateIdTest(newFixedThreadPool(threads), generations, () -> generateRandom(4));
		ResultPair pair3 = new ResultPair("Basic Random based on saml Impl", basicRaVal, "length and alpha/numeric or both customizable");
		model.put("list", Arrays.asList(pair, pair1, pair2, pair3));
		
		model.put("length", currentTimeMillis() - start);
		gdata.put(atomicInteger.incrementAndGet(), Arrays.asList(jUuidVal, osamlVal, apacheCVal, basicRaVal));
		if(gdata.size()>10){
			gdata.remove(gdata.entrySet().iterator().next().getKey());
		}
		
		for (Entry<Integer, List<Long>> string : gdata.entrySet()) {
			labels.add(string.getKey().toString());
			uuids.add(string.getValue().get(0).toString());
			samls.add(string.getValue().get(1).toString());
			acoms.add(string.getValue().get(2).toString());
			basics.add(string.getValue().get(3).toString());
		}
		
		model.put("labels", labels);
		model.put("uuids", uuids);
		model.put("samls", samls);
		model.put("acoms", acoms);
		model.put("basics", basics);
		
		return model;
	}
	 
	private long generateIdTest(ExecutorService executorService, int noOfGens, Runnable run) {
		long start = currentTimeMillis();
		for (int i = 0; i < noOfGens; i++) {
			executorService.execute(run);
		}
		executorService.shutdown();
		while (!executorService.isTerminated()) {
		}
		return currentTimeMillis() - start;
	}

	class ResultPair{
		private String name;
		private Long value;
		private String features;
		
		public ResultPair(String name, Long value, String features) {
			this.setName(name);
			this.setValue(value);
			this.setFeatures(features);
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Long getValue() {
			return value;
		}

		public void setValue(Long value) {
			this.value = value;
		}

		public String getFeatures() {
			return features;
		}

		public void setFeatures(String features) {
			this.features = features;
		}
	}
}
		