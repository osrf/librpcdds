/*************************************************************************
 * Copyright (c) 2012 eProsima. All rights reserved.
 *
 * This generated file is licensed to you under the terms described in the
 * FASTRPC_LICENSE file included in this FASTRPC distribution.
 *
 *************************************************************************
 * 
 * @file CalculatorClientExample.cxx
 * This source file shows a simple example of how to create a proxy for an interface.
 *
 * This file was generated by the tool rpcddsgen.
 */

#include "CalculatorProxy.h"
#include "Calculator.h"
#include "CalculatorDDSProtocol.h"
#include "rpcdds/transports/dds/TCPProxyTransport.h"
#include "rpcdds/exceptions/Exceptions.h"

#include <iostream>

using namespace eprosima::rpc;
using namespace ::exception;
using namespace ::transport::dds;
using namespace ::protocol::dds;

int main(int argc, char **argv)
{
	if(argc == 3)
	{
		int32_t  value1 = 0;
		int32_t  value2 = 0;

		if(sscanf(argv[1], "%d", &value1) == 1)
		{
			if(sscanf(argv[2], "%d", &value2) == 1)
            {
                CalculatorProtocol *protocol = NULL;
                TCPProxyTransport *transport = NULL;
                CalculatorProxy *proxy = NULL;

                // Creation of the proxy for interface "Calculator".
                try
                {
                    protocol = new CalculatorProtocol();
                    transport = new TCPProxyTransport("80.32.132.11:7600", "CalculatorService");
                    proxy = new CalculatorProxy(*transport, *protocol);
                }
                catch(InitializeException &ex)
                {
                    std::cout << ex.what() << std::endl;
                    return -1;
                }

                // Create and initialize return value.
                int32_t  addition_ret = 0;

                // Call to remote procedure "addition".
                try
                {
                    addition_ret = proxy->addition(value1, value2);
					std::cout << "Addition result: " << addition_ret << std::endl;
                }
                catch(SystemException &ex)
                {
                    std::cout << ex.what() << std::endl;
                }

				// Create and initialize return value.
				int32_t  subtraction_ret = 0;

				// Call to remote procedure "subtraction".
				try
				{
					subtraction_ret = proxy->subtraction(value1, value2);
					std::cout << "Subtraction result: " << subtraction_ret << std::endl;
				}
				catch(SystemException &ex)
				{
					std::cout << ex.what() << std::endl;
				}

                delete proxy ;
                delete transport ;
                delete protocol ;
            }
            else
			{
				std::cout << "Bad parameter (second value)" << std::endl;
			}
		}
		else
		{
			std::cout << "Bad parameter (first value)" << std::endl;
		}
	}
	else
	{
		std::cout << "Usage: CalculatorClient <first value> <second value>" << std::endl;
	}
   
    return 0;
}


