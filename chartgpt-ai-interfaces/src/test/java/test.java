import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class test {


   @Test
  public   void query_unanswerer_question() throws IOException {
       CloseableHttpClient httpClient=HttpClientBuilder.create().build();
       HttpGet get=new HttpGet("https://api.zsxq.com/v2/groups/48884885128118/topics?scope=unanswered_questions&count=20");
       get.addHeader("cookie","sajssdk_2015_cross_new_user=1; zsxqsessionid=f80b740b3cf26d78b8d99f2c51eff750; abtest_env=product; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22118525144854812%22%2C%22first_id%22%3A%22186d3b9a63da02-077dc9a3b6ad32-74525476-1327104-186d3b9a63e68c%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg2ZDNiOWE2M2RhMDItMDc3ZGM5YTNiNmFkMzItNzQ1MjU0NzYtMTMyNzEwNC0xODZkM2I5YTYzZTY4YyIsIiRpZGVudGl0eV9sb2dpbl9pZCI6IjExODUyNTE0NDg1NDgxMiJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22118525144854812%22%7D%2C%22%24device_id%22%3A%22186d3b9a63da02-077dc9a3b6ad32-74525476-1327104-186d3b9a63e68c%22%7D; UM_distinctid=186d3b9dd010-0e2d29bfce66b3-74525476-144000-186d3b9dd02d33; zsxq_access_token=D7ADC934-7575-0F51-1091-A9F7C0926943_E4A6F0110F8242B9");
       get.addHeader("Content-Type","application/json, text/plain, */*");

       //获取回来的请求信息,抛出异常
       CloseableHttpResponse response=httpClient.execute(get);

       //得到http响应结果的状态代码,判断
       if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){

           ////报空指针异常！坑就在这个地方，又获取的一次，response.getEntity()获取就是null
           //实体信息转换为string
          String res= EntityUtils.toString(response.getEntity());
           System.out.println(res);

       }else{
           System.out.println(response.getStatusLine().getStatusCode());
       }

    }

    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient=HttpClientBuilder.create().build();
        //注意更改topic的id值                                               //181581554842512
        HttpPost httpPost=new HttpPost("https://api.zsxq.com/v2/topics/181581554842512/answer");
        httpPost.addHeader("cookie","sajssdk_2015_cross_new_user=1; zsxqsessionid=f80b740b3cf26d78b8d99f2c51eff750; abtest_env=product; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22118525144854812%22%2C%22first_id%22%3A%22186d3b9a63da02-077dc9a3b6ad32-74525476-1327104-186d3b9a63e68c%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg2ZDNiOWE2M2RhMDItMDc3ZGM5YTNiNmFkMzItNzQ1MjU0NzYtMTMyNzEwNC0xODZkM2I5YTYzZTY4YyIsIiRpZGVudGl0eV9sb2dpbl9pZCI6IjExODUyNTE0NDg1NDgxMiJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22118525144854812%22%7D%2C%22%24device_id%22%3A%22186d3b9a63da02-077dc9a3b6ad32-74525476-1327104-186d3b9a63e68c%22%7D; UM_distinctid=186d3b9dd010-0e2d29bfce66b3-74525476-144000-186d3b9dd02d33; zsxq_access_token=D7ADC934-7575-0F51-1091-A9F7C0926943_E4A6F0110F8242B9");
        httpPost.addHeader("Content-Type","application/json, text/plain, */*");

        String paramJson="{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"我就是这样狗的，你可以把我踢了小傻瓜\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"silenced\": true\n" +
                "  }\n" +
                "}";
        //生成封装param和contentType的信息实体
        StringEntity stringEntity= new StringEntity(paramJson, ContentType.create("text/plain","UTF-8"));
     //实体对象添加
        httpPost.setEntity(stringEntity);

        //获取反馈
      CloseableHttpResponse response= httpClient.execute(httpPost);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){

            ////报空指针异常！坑就在这个地方，又获取的一次，response.getEntity()获取就是null
            //实体信息转换为string
            String res= EntityUtils.toString(response.getEntity());
            System.out.println(res);

        }else{
            System.out.println(response.getStatusLine().getStatusCode());
        }

    }





}
