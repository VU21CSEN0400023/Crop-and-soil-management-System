import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<String, String> cropSoilMap = new HashMap<>();
    private static Map<String, String> cropDiseaseMap = new HashMap<>();
    private static Map<String, String> soilNutrientMap = new HashMap<>();
    private static Map<String, String> cropWaterRequirementMap = new HashMap<>();

    static {
        // Crop and Soil Map
        cropSoilMap.put("Rice", "Clay");
        cropSoilMap.put("Wheat", "Sandy");
        cropSoilMap.put("Maize", "Loamy");
        cropSoilMap.put("Soybean", "Sandy Loam");
        cropSoilMap.put("Cotton", "Well-drained soil");
        cropSoilMap.put("Sugarcane", "Fertile soil");

        // Crop and Disease Map
        cropDiseaseMap.put("Rice", "Blast disease");
        cropDiseaseMap.put("Wheat", "Powdery mildew");
        cropDiseaseMap.put("Maize", "Downy mildew");
        cropDiseaseMap.put("Soybean", "Soybean rust");
        cropDiseaseMap.put("Cotton", "Cotton leaf curl virus");
        cropDiseaseMap.put("Sugarcane", "Sugarcane mosaic virus");

        // Soil and Nutrient Map
        soilNutrientMap.put("Clay", "High in nutrients");
        soilNutrientMap.put("Sandy", "Low in nutrients");
        soilNutrientMap.put("Loamy", "Moderate in nutrients");
        soilNutrientMap.put("Sandy Loam", "Moderate in nutrients");
        soilNutrientMap.put("Well-drained soil", "High in nutrients");
        soilNutrientMap.put("Fertile soil", "High in nutrients");

        // Crop and Water Requirement Map
        cropWaterRequirementMap.put("Rice", "High water requirement");
        cropWaterRequirementMap.put("Wheat", "Moderate water requirement");
        cropWaterRequirementMap.put("Maize", "Moderate water requirement");
        cropWaterRequirementMap.put("Soybean", "Low water requirement");
        cropWaterRequirementMap.put("Cotton", "Moderate water requirement");
        cropWaterRequirementMap.put("Sugarcane", "High water requirement");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter crop type (Rice, Wheat, Maize, Soybean, Cotton, Sugarcane): ");
        String cropType = scanner.nextLine();

        System.out.println("Enter soil type (Clay, Sandy, Loamy, Sandy Loam, Well-drained soil, Fertile soil): ");
        String soilType = scanner.nextLine();

        String recommendedCrop = getRecommendedCrop(soilType);
        String recommendedSoil = getRecommendedSoil(cropType);
        String diseaseIdentification = getDiseaseIdentification(cropType);
        String soilNutrientLevel = getSoilNutrientLevel(soilType);
        String waterRequirement = getWaterRequirement(cropType);

        System.out.println("Recommended crop for " + soilType + " soil: " + recommendedCrop);
        System.out.println("Recommended soil for " + cropType + " crop: " + recommendedSoil);
        System.out.println("Disease identification for " + cropType + " crop: " + diseaseIdentification);
        System.out.println("Soil nutrient level for " + soilType + " soil: " + soilNutrientLevel);
        System.out.println("Water requirement for " + cropType + " crop: " + waterRequirement);
    }

    private static String getRecommendedCrop(String soilType) {
        for (Map.Entry<String, String> entry : cropSoilMap.entrySet()) {
            if (entry.getValue().equals(soilType)) {
                return entry.getKey();
            }
        }
        return "No recommendation found";
    }

    private static String getRecommendedSoil(String cropType) {
        return cropSoilMap.get(cropType);
    }

    private static String getDiseaseIdentification(String cropType) {
        return cropDiseaseMap.get(cropType);
    }

    private static String getSoilNutrientLevel(String soilType) {
        return soilNutrientMap.get(soilType);
    }

    private static String getWaterRequirement(String cropType) {
        return cropWaterRequirementMap.get(cropType);
    }
}