package a_other;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		EtcEntity etcEntity = new EtcEntity();
		List<EtcDTO> byNameList = etcEntity.getEtcListByName("n1");
		
		System.out.println("0. getEtcListByName");
		System.out.println(byNameList);
		System.out.println("------------------------------");
		
		Stream<EtcDTO> etcMap = etcEntity.getEtcListByName("n1")
				.stream();
		
		System.out.println("1. getEtcListByName.stream");
		System.out.println(etcMap);
		System.out.println("------------------------------");
		
		
		Stream<EtcDTO> etcMap2 = etcEntity.getEtcListByName("n1")
		.stream()
		.distinct();
		
		System.out.println("2. getEtcListByName.stream.distinct");
		System.out.println(etcMap2);
		System.out.println("------------------------------");
		
		Map<String, EtcDTO> etcMap3 = etcEntity.getEtcListByName("n1")
		.stream()
		.distinct()
		.collect(Collectors.toMap(EtcDTO::getId, x -> x));
		
		System.out.println("3. getEtcListByName.stream.distinct.collect");
		System.out.println(etcMap3);
		System.out.println("------------------------------");
		
		Map<String, EtcDTO> etcMap4 = etcEntity.getEtcListByName("n1")
				.stream()
				.distinct()
				.collect(Collectors.toMap(EtcDTO::getId, x -> x));
		System.out.println("4. getEtcListByName.stream.distinct.collect %2");
		System.out.println(etcMap4);
		System.out.println("------------------------------");
	}
}
