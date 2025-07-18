// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

package com.kotlin.ec2

// snippet-start:[ec2.kotlin.describe_addresses.import]
import aws.sdk.kotlin.services.ec2.Ec2Client
import aws.sdk.kotlin.services.ec2.model.DescribeAddressesRequest
// snippet-end:[ec2.kotlin.describe_addresses.import]

/**
Before running this Kotlin code example, set up your development environment,
including your credentials.

For more information, see the following documentation topic:
https://docs.aws.amazon.com/sdk-for-kotlin/latest/developer-guide/setup.html
 */

suspend fun main() {
    describeEC2Address()
}

// snippet-start:[ec2.kotlin.describe_addresses.main]
suspend fun describeEC2Address() {
    Ec2Client.fromEnvironment { region = "us-west-2" }.use { ec2 ->
        val response = ec2.describeAddresses(DescribeAddressesRequest {})
        response.addresses?.forEach { address ->
            println(
                "Found address with public IP ${address.publicIp}, domain is ${address.domain}, allocation id ${address.allocationId} and NIC id: ${address.networkInterfaceId} ",
            )
        }
    }
}
// snippet-end:[ec2.kotlin.describe_addresses.main]
