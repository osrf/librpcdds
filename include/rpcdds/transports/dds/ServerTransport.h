/*************************************************************************
 * Copyright (c) 2013 eProsima. All rights reserved.
 *
 * This copy of FASTRPC is licensed to you under the terms described in the
 * FASTRPC_LICENSE file included in this distribution.
 *
 *************************************************************************/
#ifndef _TRANSPORTS_DDS_SERVERTRANSPORT_H_
#define _TRANSPORTS_DDS_SERVERTRANSPORT_H_

#include "rpcdds/fastrpc_dll.h"
#include "rpcdds/transports/dds/Transport.h"
#include "rpcdds/transports/ServerTransport.h"

#include <string>
#include <map>

class DDSDomainParticipant;
struct DDS_DomainParticipantQos;

namespace eprosima
{
    namespace rpc
    {
        namespace transport
        {
            namespace dds
            {
                class ServerProcedureEndpoint;
			}
		}
	}
}

namespace eprosima
{
    namespace rpc
    {
        namespace transport
        {
            namespace dds
            {
				/*!
                 * @brief This class is the base of all classes that implement a transport
                 * using DDS. This transport can be used by the servers.
                 * @ingroup TRANSPORTMODULE
                 */
                class ServerTransport : public eprosima::rpc::transport::ServerTransport, public Transport
                {
                    public:

                        /*!
                         * @brief Default destructor.
                         */
                        virtual FASTRPC_DllAPI ~ServerTransport();

                        /*!
                         * @brief This function returns the type of the transport.
                         *        This function has to be implemented by the child classes.
                         */
                        virtual FASTRPC_DllAPI const char* getType() const;

                        /*! TODO Actualizar
                         * @brief This function creates a new proxy procedure endpoint.
                         * This proxy procedure endpoint manages the DDS datawriter and the DDS datareader.
                         *
                         * @param name The name associated with this proxy procedure endpoint. It cannot be NULL.
                         * @param writertypename The type name of the topic that the procedure endpoint uses in the datawriter. It cannot be NULL.
                         * @param readertypename The type name of the topic that the procedure endpoint uses in the datareader. It cannot be NULL.
						 * @param initialize_data Pointer to the function to initialize DataReader received data
                         * @param copy_data Pointer to the function used to copy the data when it is received.
						 * @param finalize_data Pointer to the function to finalize DataReader received data
						 * @param ProcessFunc Pointer to the function invoked when a message is received from the server
						 * @param dataSize Size of the DataReader data structure
                         * @return 0 if the function successfully works, -1 in other case
                         * TODO
                         */
                        FASTRPC_DllAPI eprosima::rpc::transport::Endpoint*
                            createProcedureEndpoint(const char *name, const char *writertypename,
                                    const char *readertypename, bool eprosima_types,
                                    Transport::Create_data create_data, Transport::Copy_data copy_data,
                                    Transport::Destroy_data destroy_data, Transport::ProcessFunc processFunc, int dataSize);
								
						/*!
						 * @brief This method is invoked once for each incoming request.
						 *
						 * @param data The request data.
						 * @param endpoint The request endpoint.
						 */
                        FASTRPC_DllAPI void process(ServerProcedureEndpoint *endpoint, void *data);

						/*!
						 * @brief This method starts all the DDS Datawriters and Datareaders.
						 */
                        FASTRPC_DllAPI void run();

						/*!
						 * @brief This function does not apply to DDS transport.
						 */
                        FASTRPC_DllAPI void stop();

						/*!
						 * @brief This function is used to send a reply to a proxy.
						 * @param data Data to send.
						 * @param dataLength Length of the data to send.
						 * @param endpoint Endpoint meant to send the data.
						 */
                        void sendReply(void *data, size_t dataLength, Endpoint *endpoint);

						/*!
						 * @brief This function does not apply to DDS transport.
						 */
                        FASTRPC_DllAPI int receive(char *buffer, size_t bufferLength, size_t &dataToRead, Endpoint *endpoint); 

                    protected:

						/*!
                         * @brief This abstract function sets the QoS of DDS to use a specific transport.
                         *
                         * @param participantQos Reference to the DDS domain participant QoS.
                         * @param participant The domain participant that will be set to use a specific transport.
                         */
                        virtual FASTRPC_DllAPI int setTransport(DDS_DomainParticipantQos &participantQos, DDSDomainParticipant *participant) = 0;

                        /*!
                         * @brief Default constructor.
                         * @param domainId Optional parameter that specifies the domain identifier that will be used in DDS.
                         */
                        FASTRPC_DllAPI ServerTransport(const char* const &serviceName, const char* const &instanceName, int domainId = 0);

                    private:

                        /*!
                         * @brief Map containing the proxy's procedure endpoints that were created to communicate.
                         * The map key is the pointer where the name is allocated, not the name itself.
                         * Then always the same string in memory has to be used and not a copy.
                         */
                        std::map<const char*, ServerProcedureEndpoint*> m_procedureEndpoints;

                        std::string m_serviceName;

                        std::string m_instanceName;
                };
            } // namespace dds
        } // namespace transport
    } // namespace rpc
} // namespace eprosima

#endif // _TRANSPORTS_DDS_SERVERTRANSPORT_H_
