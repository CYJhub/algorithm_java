import java.util.*;

class Solution {
        static int basicTime;//기본 시간
        static int basicFee;//기본 요금
        static int unitTime;//단위 시간
        static int unitFee;//추가 단위 요금
    public int[] solution(int[] fees, String[] records) {
        //차량 번호가 작은 자동차부터 청구할 주차 요금을 차례대로 정수 배열
        int[] answer = {};
        basicTime = fees[0];
        basicFee = fees[1];
        unitTime = fees[2];
        unitFee = fees[3];
        
        Map<String, Integer> map = new TreeMap<>();//<차량번호, 누적 시간>
        Map<String, String> parking = new HashMap<>();//주차장에 현재 남아있는 차량 번호:입차 시각
        int time=0;
        //"시각 차량번호 내역"
        for(String rec:records){
            time=0;
            String[] arr = rec.split(" ");
            if(arr[2].equals("IN")){
                if(!map.containsKey(arr[1])){//처음들어오는 경우
                    map.put(arr[1],0);//차량번호와 입차한 시각 저장
                }
                parking.put(arr[1],arr[0]);//주차장에 입차
            }
            else if(arr[2].equals("OUT")){
                //주차장에 있던 시간을 계산해야 함.
                time = getTime(parking.get(arr[1]),arr[0]);//(입차시각, 출차시각);
                map.put(arr[1],map.getOrDefault(arr[1],0)+time);
                parking.remove(arr[1]);//주차장에서 출차
            }
        }
        if(!parking.isEmpty()){//아직 주차장에 남아있는 차량 처리
            for(Map.Entry<String,String> car:parking.entrySet()){
                String carNum = car.getKey();
                String inTime = car.getValue();
                time = getTime(inTime,"23:59");
                map.put(carNum,map.getOrDefault(carNum,0)+time);
            }
        }
        for(Map.Entry<String,Integer> car:map.entrySet()){
            map.put(car.getKey(),calculateFee(car.getValue()));
        }
        System.out.println(map);
        //차량 번호가 작은 자동차부터 청구할 주차 요금을 차례대로 정수 배열
        List<Integer> list = new ArrayList<>(map.values());
        
        
        return list.stream().mapToInt(x->x).toArray();
    }
    private static int calculateFee(int time){
        int fee=0;
        if(time<=basicTime){
            fee = basicFee;
        }
        else{
            fee = basicFee + ((time-basicTime+unitTime-1)/unitTime)*unitFee;
        }
        
        return fee;
    }
    private static int getTime(String start, String end){
        int sum=0;
        String[] arr1 = start.split(":");
        String[] arr2 = end.split(":");
        
        sum = (toInt(arr2[0])*60 + toInt(arr2[1])) - (toInt(arr1[0])*60 + toInt(arr1[1]));
        
        return sum;
    }
    
    private static int toInt(String str){
        return Integer.parseInt(str);
    }
}
//올림 공식: (n+m-1)/m