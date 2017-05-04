package com.aws.cloudproject;

import com.amazonaws.auth.AWSCredentials;

import com.amazonaws.auth.AWSStaticCredentialsProvider;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.ec2.AmazonEC2;

import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import com.amazonaws.services.ec2.model.DescribeInstancesResult;
import com.amazonaws.services.ec2.model.Instance;
import com.amazonaws.services.ec2.model.Reservation;

 
public class GetServerInfo
{
  public void getInfo4Server(String Key, String KeyID) throws Exception
  {	  
	  AWSCredentials credentials = new ProfileCredentialsProvider().getCredentials();

    AmazonEC2 ec2 = AmazonEC2ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials)).build();

     ec2 = AmazonEC2ClientBuilder.standard()
            .withRegion(Regions.US_WEST_2)
            .build();
    DescribeInstancesResult insResult = ec2.describeInstances();
 
    int count = 1;
    for (Reservation reservation : insResult.getReservations())
    {
      for(Instance instance : reservation.getInstances())
      {
        System.out.println("Instance # " + count++
                + "\n InstanceId: " + instance.getInstanceId()
                + "\n InstanceType: " + instance.getInstanceType()
                + "\n Public IP: " + instance.getPublicIpAddress()
                + "\n getKeyName: " + instance.getKeyName() 
                + "\n getLaunchTime: " + instance.getLaunchTime() 
                + "\n getAmiLaunchIndex: " + instance.getVirtualizationType() 
                + "\n getPlatform: " + instance.getArchitecture() );
      }
    }
  }
}