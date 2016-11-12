package taxRateVerifier;


// checks exemption
public class TaxRateVerifier {
	
	// checks if item is excluded from sales taxes 
	public static boolean isSalesTaxExempt(String record) {
		if(record.contains("book") | record.contains("chocolate") | record.contains("pills")){
			return true;
		}
		else {
			return false;
		}
	}
	
	// checks if there should be import duty for an item
	public static boolean isImportDutyExempt(String record) {
		if(record.contains("imported")){
			return false;
		}
		else{
			return true;
		}
	}
	
	// determines how much tax to charge
	public static double setTaxRate(String record){
		if(isSalesTaxExempt(record) == false & isImportDutyExempt(record) == false){
			return 0.15;
		}
		else if(isSalesTaxExempt(record) == false){
			return 0.10;
		}
		else if(isImportDutyExempt(record) == false){
			return 0.05;
		}
		else {
			return 0.0;
		}
	}	
}

