package HTTP;

public class HttpStatusChecker {

    public String getStatusImage(int code) {
        String url = "https://http.cat" + "/" + code + ".jpg";
        int statusCode = UtilClass.getRequestStatus(url);

        if (statusCode == 0 || statusCode == 404) {
            throw new RuntimeException("Image not found");
        } else {
            return url;
        }

    }
}

