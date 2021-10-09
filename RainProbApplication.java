public class RainCloudFarming {
	public static ArrayList<Integer> rainDropsList= new ArrayList<>();
	
	public static void main(String[] args) {
		int cropX=10;
		int cropY =5;
		int minDropsReqForPlant=3;//default 1
		putWatertoPlants(cropX,cropY,minDropsReqForPlant);
	}

	private static void putWatertoPlants(int cropX, int cropY, int minDropsReqForPlant) {
		int[][] crop= new int[cropX][cropY];
		for(int[] arr: crop)
			Arrays.fill(arr, 0);
		int i=0;
		int j=0;
		int time=0;
		while(crop[cropX-1][cropY-1] < minDropsReqForPlant) {
			int rainDrops=generateRainCloud();
			time++;
			while(i<cropX) {
				if(rainDrops==0)
					break;
				while(j<cropY){
					if(crop[i][j]<minDropsReqForPlant) {
						int req=minDropsReqForPlant-crop[i][j];
						if(req<=rainDrops) {
							crop[i][j]=crop[i][j]+req;
							rainDrops -=req;
						}else {
							crop[i][j]=crop[i][j]+rainDrops;
							rainDrops =0;
						}
						if(rainDrops==0)
							break;
					}
					j++;
				}
				if(j==cropY) {
					j=0;i++;
				}
			}
		}
		System.out.println("time required to wet plants : "+time);
		System.out.println("rainDrops "+rainDropsList.toString());
		printCrop(cropX, cropY, crop);
	}

	private static void printCrop(int cropX, int cropY, int[][] crop) {
		System.out.println("Crop Matrix");
		for(int k=0;k<cropX;k++) {
			for(int l=0;l<cropY;l++){
				System.out.print(crop[k][l]+" ");
			}
			System.out.println();
		}
	}
	private static int generateRainCloud() {
		int min=1;
		int max=10;
		
		int rainDrops=new Random().nextInt(max - min + 1) + min;
		rainDropsList.add(rainDrops);
		return rainDrops;
	}
	

}
