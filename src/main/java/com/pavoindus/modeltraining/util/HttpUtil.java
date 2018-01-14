package com.pavoindus.modeltraining.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

public class HttpUtil {

    private static final Log logger = LogFactory.getLog(HttpUtil.class);

    private static HttpUtil instance;

    private HttpUtil() {
    }

    public static HttpUtil getInstance() {
        if (instance == null) {
            instance = new HttpUtil();
        }
        return instance;
    }

    public String call(String uri, String params, Map<String, String> headers, String method) {
        StringBuilder response = new StringBuilder();
        try {
            URL url = new URL(uri);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(method);
            connection.setDoOutput(true);
            StringBuilder sj = new StringBuilder();
            /*for (Map.Entry<String, String> entry : params.entrySet()) {
                sj.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                sj.append("=");
                sj.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                sj.append("&");
            }*/
            byte[] out = params.getBytes();

            connection.setFixedLengthStreamingMode(out.length);
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                connection.setRequestProperty(entry.getKey(), entry.getValue());
            }
            connection.connect();
            try (DataOutputStream os = new DataOutputStream(connection.getOutputStream())) {
                os.write(out);
                os.flush();
            } catch (Exception e) {
                logger.error(e);
                return "";
            }
            int responseCode = connection.getResponseCode();
            try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
            } catch (Exception e) {
                LogFactory.getLog(HttpUtil.class).error(e);
                return "";
            }
            return response.toString();
        } catch (Exception e) {
            logger.error("Something went wrong while authenticating...", e);
            return "";
        }
    }
}
