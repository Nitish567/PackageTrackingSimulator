import java.util.Random;

public class PackageAttributes {
	
	
	
	public static long id=0;
	public static long getId() {
		return id;
	}

	public static void setId(long id) {
		PackageAttributes.id = id;
	}
	public float weight;
	public String dimensions;
	public int totalpieces;
	public String signaturerequiredatSource = null;
	public String packaging = null;
	public String service = null;
	public String specialhandling = null;
	public String source = null;
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String destination = null;

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public String getDimensions() {
		return dimensions;
	}

	public void setDimensions(String dimensions) {
		this.dimensions = dimensions;
	}

	public int getTotalpieces() {
		return totalpieces;
	}

	public void setTotalpieces(int totalpieces) {
		this.totalpieces = totalpieces;
	}

	public String getSignaturerequiredatSource() {
		return signaturerequiredatSource;
	}

	public void setSignaturerequiredatSource(String signaturerequiredatSource) {
		this.signaturerequiredatSource = signaturerequiredatSource;
	}

	public String getPackaging() {
		return packaging;
	}

	public void setPackaging(String packaging) {
		this.packaging = packaging;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getSpecialhandling() {
		return specialhandling;
	}

	public void setSpecialhandling(String specialhandling) {
		this.specialhandling = specialhandling;
	}

	PackageAttributes(float weightofpackage, String dimensions2, int items, String packaging2, String signatureservice, String service2, String specialhandlingsection, String source2, String destination2){
		this.weight = weightofpackage;
		this.signaturerequiredatSource = signatureservice;
		this.packaging = packaging2;
		this.service = service2;
		this.dimensions = dimensions2;
		this.totalpieces = items;
		this.specialhandling = specialhandlingsection;
		this.source = source2;
		this.destination = destination2;
		id = trackingID();
		
	}
	
	public long trackingID(){
//		id = 17;
//		id = 31 * id + this.totalpieces;
//		return id;
		
		 Random random = new Random();
		    char[] digits = new char[12];
		    digits[0] = (char) (random.nextInt(9) + '1');
		    for (int i = 1; i < 12; i++) {
		        digits[i] = (char) (random.nextInt(10) + '0');
		    }
		    return Long.parseLong(new String(digits));
		
		
	}
	public void Print(){
		System.out.println(weight);
		System.out.println(signaturerequiredatSource);
		System.out.println(packaging);
		System.out.println(service);
		System.out.println(dimensions);
		System.out.println(totalpieces);
		System.out.println(specialhandling);
		System.out.println(id);
		System.out.println(source);
		System.out.println(destination);
	}
	
}
