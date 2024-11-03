import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class ConsultarMoneda {
    public Monedas buscarMoneda(String monedaBase, String monedaTarget) {
        // Corregir la URL para realizar la consulta de conversión correctamente
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/b8a944be4b643e842dd1758a/latest/" + monedaBase);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            // Convertir la respuesta a un mapa para obtener la tasa de cambio
            Map<String, Object> responseMap = new Gson().fromJson(response.body(), Map.class);
            String baseCode = (String) responseMap.get("base_code");
            Map<String, Double> conversionRates = (Map<String, Double>) responseMap.get("conversion_rates");

            double conversionRate = conversionRates.get(monedaTarget);
            return new Monedas(baseCode, monedaTarget, conversionRate);
        } catch (Exception e) {
            throw new RuntimeException("No encontré la moneda: " + e.getMessage());
        }
    }
}

