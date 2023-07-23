package HTTP;

import java.util.Scanner;

public class HttpImageStatusCli {


    public void askStatus() {
        Scanner scanner = new Scanner(System.in);
        HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();
        int code = 0;
        System.out.println("Please enter code, or enter 'exit' to stop the program: ");

        while (scanner.hasNext()) {
            if (scanner.hasNextLine()) {
                String codeString = scanner.nextLine();

                if ("exit".equals(codeString)) {
                    return;
                }

                try {
                    code = Integer.parseInt(codeString);
                } catch (RuntimeException e) {
                    System.out.print("Please enter valid code");
                    continue;
                }

                try {
                    downloader.downloadStatusImage(code);
                } catch (RuntimeException e) {
                    System.out.println("There is not image for HTTP status " + code);
                }

                System.out.print("Enter HTTP status code or 'exit'");
            }
        }
        scanner.close();
    }
}
