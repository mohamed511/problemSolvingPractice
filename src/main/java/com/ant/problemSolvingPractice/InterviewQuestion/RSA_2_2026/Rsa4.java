package com.ant.problemSolvingPractice.InterviewQuestion.RSA_2_2026;

import java.util.Map;
/**
 * Builder is one of the most widely used Creation Design Patterns. It abstracts the instantiation
 * of a complex object and provides a fluent API for creating an instance.
 *
 * Here is an example of a URL address with its parts:
 *
 * http://www.codility.com:8080/test/hello/world?key1=value1&key2=value2
 * |_____|  |_____________| |____| |_____________________| |_____________________|
 * scheme       host        port           path                 query params
 *
 *
 * Your task
 * Your task is to develop a UrlBuilder class to create a URL in a more fluent way:
 *
 * • https()       – changes default http to https
 * • host(String)  – sets host
 * • port(int)     – sets port
 * • path(String)  – sets path
 * • queryParams(Map<String, String>) – sets query parameters (see Examples)
 * • build()       – returns a URL built by the previously called methods
 *
 * Assumptions
 *
 * • Assume the path() method is always invoked with / at the beginning of the string.
 * • Assume the data passed to methods is valid and doesn't need to be escaped or sanitized.
 * • The order of query params doesn't matter, so given
 *     queryParams(new HashMap<String, String> {{ "key1", "value1" }, { "key2", "value2" }})
 *   both
 *     ?key1=value1&key2=value2
 *   and
 *     ?key2=value2&key1=value1
 *   are valid.
 *
 *
 * Examples
 *
 * Below is the list of example UrlBuilder executions and their expected results:
 *
 * new UrlBuilder()
 *     .port(8080)
 *     .host("codility.com")
 *     .https()
 *     .build();
 * // https://codility.com:8080
 *
 * new UrlBuilder()
 *     .host("codility.com")
 *     .path("/test/hello/world")
 *     .queryParams(new Map<string, string> {{ "key1", "value1" }, { "key2", "value2" }})
 *     .build();
 * // http://codility.com/test/hello/world?key1=value1&key2=value2
 *
 * Below is the list of example UrlBuilder executions and their expected results:
 *
 * new UrlBuilder()
 *     .port(8080)
 *     .host("codility.com")
 *     .https()
 *     .build();
 * // https://codility.com:8080
 *
 * new UrlBuilder()
 *     .host("codility.com")
 *     .path("/test/hello/world")
 *     .queryParams(new Map<string, string> { { "key1", "value1" }, { "key2", "value2" } })
 *     .build();
 * // http://codility.com/test/hello/world?key1=value1&key2=value2
 *
 * Hints
 * • You can use System.out.println() for debugging purposes.
 * **/
public class Rsa4 {
}

class UrlBuilder {
    public static void main(String[] args) {
        String s =
        new UrlBuilder()
                .port(8080)
                .host("codility.com")
                .https()
                .build();

    }
    private String scheme = "http";   // default is http
    private String host;
    private Integer port;
    private String path;
    private Map<String, String> queryParams;

    public UrlBuilder https() {
        this.scheme = "https";
        return this;
    }

    public UrlBuilder host(String host) {
        this.host = host;
        return this;
    }

    public UrlBuilder port(int port) {
        this.port = port;
        return this;
    }

    public UrlBuilder path(String path) {
        this.path = path;   // assumption: always starts with "/"
        return this;
    }

    public UrlBuilder queryParams(Map<String, String> queryParams) {
        this.queryParams = queryParams;
        return this;
    }

    public String build() {
        StringBuilder sb = new StringBuilder();

        sb.append(scheme).append("://").append(host);

        if (port != null) {
            sb.append(":").append(port);
        }

        if (path != null) {
            sb.append(path);
        }

        if (queryParams != null && !queryParams.isEmpty()) {
            sb.append("?");
            boolean first = true;
            for (Map.Entry<String, String> entry : queryParams.entrySet()) {
                if (!first) sb.append("&");
                sb.append(entry.getKey()).append("=").append(entry.getValue());
                first = false;
            }
        }

        return sb.toString();
    }

}
