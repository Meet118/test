package top.t5d.administration.Utils;

import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;

import com.tencentcloudapi.ses.v20201002.SesClient;
import com.tencentcloudapi.ses.v20201002.models.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SendMail {

    private Credential credential;

    private HttpProfile httpProfile;

    private ClientProfile clientProfile;

    private SesClient sesClient;

    private SendEmailRequest sendEmailRequest;

    private Template template;

}
