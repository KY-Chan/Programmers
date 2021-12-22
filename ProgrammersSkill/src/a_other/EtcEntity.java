package a_other;

import java.util.ArrayList;
import java.util.List;

public class EtcEntity {
	List<EtcDTO> etcList = new ArrayList<EtcDTO>();
	public EtcEntity() {
		for (int i = 0; i < 10; i++) {
			EtcDTO newEtc = new EtcDTO("" + i, "n" + i % 3, "e" + i % 3, "a" + i % 3);
			etcList.add(newEtc);
		}
	}
	
	public List<EtcDTO> getEtcListByName(String name) {
		List<EtcDTO> byNameList = new ArrayList<EtcDTO>();
		for(int i = 0; i < 10; i++) {
			if(etcList.get(i).getName().equals(name)) {
				byNameList.add(etcList.get(i));
			}
		}
		return byNameList;
	}
}
