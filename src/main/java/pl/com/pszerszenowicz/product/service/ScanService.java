package pl.com.pszerszenowicz.product.service;

import org.springframework.stereotype.Service;
import pl.com.pszerszenowicz.model.ProductInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class ScanService {

    private static final Random random = new Random();

    public static final Map<Integer, ProductInfo> drugs = Map.of(
            1, ProductInfo.builder()
                    .name("Ibuprofen Forte Doz")
                    .details("1 tabletka powlekana zawiera 400mg ibuprofenu oraz substancje pomocnicze\n" +
                            "DOZ S.A")
                    .quantity(60)
                    .quantityType(ProductInfo.QuantityType.szt)
                    .build(),
            2, ProductInfo.builder()
                    .name("Solian 400mg")
                    .details("1 tabletka zawiera jako substancję czynną: amisulpryd 400mg oraz substancje pomocnicze, w tym laktozę jednowodną\n" +
                            "Sanofi Wintrop Industrie")
                    .quantity(30)
                    .quantityType(ProductInfo.QuantityType.szt)
                    .build(),
            3, ProductInfo.builder()
                    .name("Witamina D3K2 Forte")
                    .details("Zawartość w kropli: witamina D3 50ug/2000 j.m.(1000%), witamina K2 50ug (67%)\n" +
                            "Dr. Jacob's Poland")
                    .quantity(20)
                    .quantityType(ProductInfo.QuantityType.ml)
                    .build(),
            4, ProductInfo.builder()
                    .name("APAP extra")
                    .details("1 tabletka zwiera substancje czynne: paracetamol 500mg, kofeinę 65mg\n" +
                            "US Pharmacia Sp. z o.o")
                    .quantity(10)
                    .quantityType(ProductInfo.QuantityType.szt)
                    .build(),
            5, ProductInfo.builder()
                    .name("Vitamin C+")
                    .details("Vitamin C+ to suplement diety zawierający witaminę C, bioflawonoidy cytrusowe oraz ekstrakt z owoców dzikiej róży\n" +
                            "KFD Sp. z o.o")
                    .quantity(176)
                    .quantityType(ProductInfo.QuantityType.g)
                    .build(),
            6, ProductInfo.builder()
                    .name("Omega 3+")
                    .details("1 kapsułka zawiera: olej rybi: 1000mg w tym EPA 360mg, DHA 240mg, Witamina E: 12mg (100% RWS)\n" +
                            "KFD Sp. z o.o")
                    .quantity(90)
                    .quantityType(ProductInfo.QuantityType.szt)
                    .build(),
            7, ProductInfo.builder()
                    .name("Cynk + Magnez + B6 Active")
                    .details("Kompozycja biodostępnego, organicznego cynku i magnezu oraz aktywnej formy witaminy B6 w postaci pirydoksalo-5-fosforanu\n" +
                            "Pharmovit")
                    .quantity(120)
                    .quantityType(ProductInfo.QuantityType.szt)
                    .build()
    );

    public ProductInfo processScan(String barcode) {
        return switch (nullableCharAt(barcode, 2)) {
            case "1" -> drugs.get(1);
            case "2" -> drugs.get(2);
            case "3" -> drugs.get(3);
            case "4" -> drugs.get(4);
            case "5" -> drugs.get(5);
            case "6" -> drugs.get(6);
            case "7" -> drugs.get(7);
            default -> getRandomDrug();
        };
    }

    private String nullableCharAt(String s, int index) {
        try {
            return String.valueOf(s.charAt(index));
        } catch (StringIndexOutOfBoundsException e) {
            return "";
        }
    }

    private ProductInfo getRandomDrug() {
        List<ProductInfo> drugList = new ArrayList<>(drugs.values());
        int randomIndex = random.nextInt(drugList.size());
        return drugList.get(randomIndex);
    }
}
