//package com.example.resourceoptimizer.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
//import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
//import software.amazon.awssdk.regions.Region;
//import software.amazon.awssdk.services.s3.S3Client;
//
//@Configuration
//public class AwsConfig {
//
//    @Value("${aws.access.key.id}")
//    private String awsKeyId;
//
//    @Value("${aws.secret.access.key}")
//    private String awsKeySecret;
//
//    @Value("${aws.region}")
//    private String region;
//
//    @Bean
//    public S3Client s3Client() {
//        return S3Client.builder()
//                .credentialsProvider(StaticCredentialsProvider.create(
//                        AwsBasicCredentials.create(awsKeyId, awsKeySecret)))
//                .region(Region.of(region))
//                .build();
//    }
//
//    // Additional beans for other AWS services (EC2, RDS, CloudWatch, etc.)
//}
