/*************************************************************************
 * Copyright (c) 2013 eProsima. All rights reserved.
 *
 * This copy of FASTRPC is licensed to you under the terms described in the
 * FASTRPC_LICENSE file included in this distribution.
 *
 *************************************************************************/

#ifndef _TRANSPORT_DDS_UDPPROXYTRANSPORT_H_
#define _TRANSPORT_DDS_UDPPROXYTRANSPORT_H_

#include "rpcdds/fastrpc_dll.h"
#include "rpcdds/transports/dds/ProxyTransport.h"

namespace eprosima
{
    namespace rpc
    {
        namespace transport
        {
            namespace dds
            {
                /*!
                 * @brief This class implements a transport using DDS over UDPv4.
                 * This transport only can be used by a server's proxy.
                 * @ingroup TRANSPORTMODULE
                 */
                class UDPProxyTransport : public ProxyTransport
                {
                    public:

                        /*!
                         * @brief Default constructor for server's proxies.
						 * @param remoteServiceName Name of the service
                         * @param domainId Optional parameter that specifies the domain identifier to be used in DDS.
						 * @param timeout The time in milliseconds to wait for the reply.
                         */
                        FASTRPC_DllAPI UDPProxyTransport(const char* const &remoteServiceName, const char* const &instanceName, int domainId = 0, long timeout = 10000L);

                        /*!
                         * @brief Constructor for server's proxies.
                         *
                         * @param to_connect IP address where the server can be found by the proxy. For example: "192.168.1.3"
						 * @param remoteServiceName Name of the service
                         * @param domainId Optional parameter that specifies the domain identifier to be used in DDS.
						 * @param timeout The time in milliseconds to wait for the reply.
                         */
                        FASTRPC_DllAPI UDPProxyTransport(const char* const &to_connect, const char* const &remoteServiceName, const char* const &instanceName, int domainId = 0, long timeout = 10000L);

                        //! @brief Default destructor.
                        virtual FASTRPC_DllAPI ~UDPProxyTransport();

                        /*!
                         * @brief This function sets the QoS of DDS to use the UDPv4 transport.
                         *
                         * @param participantQos Reference to the DDS domain participant QoS.
                         * @param participant The domain participant that will be set to use UDPv4 transport. 
                         */
                        virtual FASTRPC_DllAPI int setTransport(DDS_DomainParticipantQos &participantQos, DDSDomainParticipant *participant);

                    private:

                        //! @brief The IP address where the proxy can find the server. This attribute is only used by the proxy.
                        char *m_to_connect;
                };
            } // namespace dds
        } // namespace transport
    } // namespace rpc
} // namespace eprosima
#endif // _TRANSPORT_DDS_UDPPROXYTRANSPORT_H_
