package ca.uhn.example.elasticsearch;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

public class ElasticsearchClient {

  private ElasticsearchClient() {
  }

  private static String host = "localhost";
  private static Integer port = 9200;
  private static String scheme = "http";
  // TODO catch errors that can occur when building the client
  private static RestHighLevelClient client = new RestHighLevelClient(
      RestClient.builder(new HttpHost(host, port, scheme)));

  public static RestHighLevelClient getInstance() {
    return client;
  }
}
