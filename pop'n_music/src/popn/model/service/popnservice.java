package popn.model.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import popn.model.dto.Popn_music;

public class popnservice {

	
	private Scanner sc = new Scanner(System.in);
	
	private Set<Popn_music> musicSet = new HashSet<Popn_music>();

	private Map<Integer, String > difficultyMap = new HashMap< Integer ,String>();

	
	
	
	public popnservice() {
		
	
		
		difficultyMap.put(1, "Easy");
		difficultyMap.put(2, "Normal" );
		difficultyMap.put(3, "Hyper" );
		difficultyMap.put(4, "Ex");
		
		
		
		
	
		musicSet.add(new Popn_music("neu", "wac", "?", "15_ADVENTURE", 199, difficultyMap(1, 2, 3, 4), "20/30/40/50") );
		musicSet.add(new Popn_music("생명의 불꽃을 감아서", "WALPULG", "Flamme", "21_SunnyPark", 180, difficultyMap(1, 2, 3, 4), "15/31/42/49"));
		musicSet.add(new Popn_music("음악", "변사칸타빌레오", "the TOWER", "17_THE MOVIE", 210_360, difficultyMap(1, 2, 3, 4), "20/30/40/50"));
		musicSet.add(new Popn_music("Chaos:Q", "nonuplet", "?", "24_토끼,고양이,소년의꿈", 100_402, difficultyMap(1, 2, 3, 4), "20/40/50"));
	

		
		
	}
	
	


	public Set<String> difficultyMap(Integer... difficulty ) {

		Set<String> addedDifficulty = new LinkedHashSet<String>();

		for (Integer difficultyKey : difficulty) {

			String difficultyValue = difficultyMap.get(difficultyKey);


			if (difficultyValue != null) { 
				addedDifficulty.add(difficultyValue);
			}

		}

		return addedDifficulty;
	}

	
	
	
	public void displayMenu() {
		
		int menuNum = 0;
		
		
		do {
			System.out.println("\n - Pop'n Music Settings - \n");
			System.out.println("1. 수록곡 정보 조회");
			System.out.println("2. 추가곡 수록");
			System.out.println("3. 수록곡 삭제");
			System.out.println("4. 버전 순으로 조회");
			System.out.println("5. Upper 난이도 추가");
			System.out.println("6. Upper 난이도 제거");
			System.out.println("0. 프로그램 종료");
			System.out.print("선택 : ");

			try {

				menuNum = sc.nextInt();

				switch (menuNum) {
				case 1: displayAllMusic(); break;
				
				case 2: createNewMusic(); break;
				
				case 3: deleteMusic(); break;
				
				case 4: displayMusicByUpdateVersion(); break;
					
				case 5:	addDifficultyType();		break;
				case 6: removeDifficultyType(); 	break;
				case 7 : musicUpdate(); break;
				case 0: System.out.println("프로그램종료");					break;
				default: System.out.println("잘못된 입력");

				}

			} catch (Exception e) {
				System.out.println("오입력입니다");
				e.printStackTrace();

				sc.nextLine(); 

				menuNum = -1;
			}

		} while (menuNum != 0);

	}
		
	
	/////////////////////////////////
	
		
	public void displayAllMusic() throws Exception{
		System.out.println("<전체 곡 리스트 목록>");
		
		
		for(Popn_music music : musicSet) {
			System.out.println( music);
			
		}
	}
		
		
	
	//////////////////////////////
	
	
		
		
	public void  createNewMusic () throws Exception {
		
		System.out.println("추가 곡명");
		String musicName = sc.next();
		
		
		for(Popn_music jungbokmusic : musicSet) {
			
			if(jungbokmusic.getMusicName().equals(musicName)) {
				System.out.println("중복임");
				return;
			}
			
			
			
		}
		
		System.out.print(" 작곡가명 : ");
		String composerName = sc.next();
		System.out.print(" 담당 캐릭터 : ");
		String character = sc.next();

		System.out.print(" 업데이트 버전 : ");
		String updateVersion = sc.next();

		System.out.print(" BPM : ");
		int Bpm = sc.nextInt();

		
		
		
		
		
		
		
		Set<String> dfclttp = new LinkedHashSet<String>();
		
		System.out.println("난이도 체계 목록");
		
		
		
		
		
		
		
		
		for( Entry<Integer, String> entry  : difficultyMap.entrySet() ) {
			System.out.println(  entry.getKey() + " : " + entry.getValue() );
		}
		
		
		
		
		
		
		
		
		while(true) {
			
			System.out.println("타입 입력 (종료: 0 ");
			
			System.out.println();
			
			int input = sc.nextInt();
			
			if(input == 0) {
				break;
							
							
			} 
			
			String popn = difficultyMap.get(input);
			
			
			if (dfclttp.contains(popn)){
				
				System.out.println("중복");
				
			}else {
				
				dfclttp.add(popn);
				System.out.println("채보추가완료");
				System.out.println();
			}
			
			
			
		}
		
		
		
		
		
		
		
		
		

//		System.out.println(" 난이도 입력 - 설정한 난이도의 갯수만큼 숫자입력 ex) 3개일경우 20/30/40");
//		System.out.println("<난이도 레벨 설정은 1~50을 권장합니다>");
		
		
		
		
		int i = 0;
		String diff = "";
		while( i < dfclttp.size()) {
			
			System.out.println(" 난이도 레벨 입력 ");
		
			int difficultyLev = sc.nextInt();
			
			String difficulty = difficultyLev + "  "; 
			
			
			i++;
			diff += difficulty;
		}
		
		
		

		Popn_music newMusic = new Popn_music(musicName, composerName, character, updateVersion,Bpm,dfclttp , diff  );
		
		musicSet.add(newMusic);
		
		
		
	}
	
	
	//////////////////////////////
	
	
	
	public void deleteMusic() throws Exception {
		System.out.print("삭제할 곡의 이름을 입력 : ");
		String musicName = sc.next();
		
		boolean flag = false;
		
		for(Popn_music music : musicSet) {
			
			if(music.getMusicName().equals(musicName)) {
				musicSet.remove(music);
				
				flag = true;
				break; 
				
			}
			
		}
		
		if(flag) {
			System.out.println("곡 삭제됨.");
		} else {
			System.out.println("곡 확인 불가");
		}
		
	}
	
	
	
	
	//////////////////////////////
	
	public void musicUpdate() throws Exception {
		
		
		
		
		List<Popn_music> musicList = new ArrayList<Popn_music>(musicSet);

		System.out.println("번호 입력");
		
		int index = sc.nextInt();		
		
		
		
		if(musicList.isEmpty()){		
			return ;
		} else if (index < 0) {
			System.out.println("음수는 입력할 수 없습니다.");
			return; 
			// 3) studentList 범위 내 인덱스번호인지 검사
		} else if (index >= musicList.size()) {
			System.out.println("범위를 넘어선 값을 입력할 수 없습니다"); 
			return;
			

			// 4) 만약 문자열을 입력한 경우 -> 예외처리 throws
		} else {
			
			
			
			System.out.println("추가 곡명");
			String musicName = sc.next();
			
			
			for(Popn_music jungbokmusic : musicSet) {
				
				if(jungbokmusic.getMusicName().equals(musicName)) {
					System.out.println("중복임");
					break;
				}
				
				
				
			}
			
			System.out.print(" 작곡가명 : ");
			String composerName = sc.next();
			System.out.print(" 담당 캐릭터 : ");
			String character = sc.next();

			System.out.print(" 업데이트 버전 : ");
			String updateVersion = sc.next();

			System.out.print(" BPM : ");
			int Bpm = sc.nextInt();

			
						
									
			
			Set<String> dfclttp = new LinkedHashSet<String>();
			
			System.out.println("난이도 체계 목록");
							
									
			for( Entry<Integer, String> entry  : difficultyMap.entrySet() ) {
				System.out.println(  entry.getKey() + " : " + entry.getValue() );
			}
			
			
			
			
			
			
			
			
			while(true) {
				
				System.out.println("타입 입력 (종료: 0 ");
				
				System.out.println();
				
				int input = sc.nextInt();
				
				if(input == 0) {
					break;
								
								
				} 
				
				String popn = difficultyMap.get(input);
				
				
				if (dfclttp.contains(popn)){
					
					System.out.println("중복");
					
				}else {
					
					dfclttp.add(popn);
					System.out.println("채보추가완료");
					
				}
				
				
				
			}
			
			
			

			
			int i = 0;
			String diff = "";
			while( i < dfclttp.size()) {
				
				System.out.println(" 난이도 레벨 입력 ");
			
				int difficultyLev = sc.nextInt();
				
				String difficulty = difficultyLev + "  "; 
				
				
				i++;
				diff += difficulty;
			}
			
			
			
			
			
			
			

			musicList.set(index, new Popn_music(musicName, composerName, character, updateVersion,Bpm,dfclttp , diff  ));
			System.out.println(musicList);
			
			musicSet.addAll(musicList);
			
			
			
			
		}
		
		
		
		
		
		
		
		
		
	}

	
	
	/////////////////////////////////
	
	public void displayMusicByUpdateVersion() {
		
		System.out.println("<버전 순으로 조회>");
		
		List<Popn_music> musicList = new  ArrayList<Popn_music>(musicSet);
		
		
		musicList.sort(Comparator.comparing(Popn_music::getUpdateVersion));
		
		for(Popn_music music : musicList) {
			System.out.println( music);
			
		}
		
		
		
	}
	
	
	
	
	////////////////////////////////////////
	
	
	
public void addDifficultyType() {
	for( Entry<Integer, String> entry  : difficultyMap.entrySet() ) {
		System.out.println(  entry.getKey() + " : " + entry.getValue() );
	}
System.out.println("Upper 난이도를 추가하려면 해당 난이도의 key를 입력하세요");
System.out.println("1~4까지만 입력");
	
	int key = sc.nextInt();

	
	if(key>4 || key<1) {
		System.out.println("1~4만 입력"); 
		
	}else if(key >0 && key <5) {
		

		int upperkey = key + 4;
		
		

		//
		String upper = difficultyMap.get(key);
		//
		String upperdifficulty = "Upper" + upper ;
		
		difficultyMap.put(upperkey, upperdifficulty);
		
		System.out.println("Upper 난이도가 추가되었습니다.");
		
		
		
	} else {
		System.out.println("오입력");
	}
	
	
	
	
 }
	
	
public void removeDifficultyType() {
	
	
	
	System.out.println("추가되어있는 Upper 난이도를 제거");
	System.out.println("기본 난이도는 제거할 수 없습니다");
	
	for( Entry<Integer, String> entry  : difficultyMap.entrySet() ) {
		System.out.println(  entry.getKey() + " : " + entry.getValue() );
	}
	
	


	
	
	int key = sc.nextInt();
	
	
	
	
	for( Entry<Integer, String> entry  : difficultyMap.entrySet() ) {
		

		if(key >0 && key <5) {
			
			System.out.println(" 기본 난이도는 제거할 수 없습니다. ");
			break;
		} else if (key > 4) {
			
			difficultyMap.remove(key);
			
			System.out.println("제거 완료");
			
			
			break;
			
		} else {
			
			System.out.println(" 해당 Upper 난이도가 존재하지 않거나 번호를 잘못입력하였습니다");
			break;
		}
		
		
	}
	
	
	
	
	
	
}



	
}
	
	
	
	
	
