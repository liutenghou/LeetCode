
public class DailyTemperatures {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] dailyTemperatures(int[] T) {
        if(T == null) return null;
        
        int[] days = new int[T.length];
        
        for(int i=0; i<T.length; i++){
            
            int today = T[i];
            int count = 0;
            for(int j=i+1; j<T.length; j++){
                count++;
                if(T[j] > today){
                    days[i] = count;
                    break;
                }
            }
        }
        return days;
    }
}
