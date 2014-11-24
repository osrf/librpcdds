/*************************************************************************
 * Copyright (c) 2012 eProsima. All rights reserved.
 *
 * This generated file is licensed to you under the terms described in the
 * FASTRPC_LICENSE file included in this FASTRPC distribution.
 *
 *************************************************************************
 * 
 * @file CalculatorAsyncSupport.h
 * This header file contains functionality to use asynchronous calls for all interfaces.
 *
 * This file was generated by the tool rpcddsgen.
 */

#ifndef _Calculator_DDS_ASYNC_SUPPORT_H_
#define _Calculator_DDS_ASYNC_SUPPORT_H_

#include "rpcdds/transports/dds/DDSAsyncTask.h"
#include "rpcdds/exceptions/UserException.h"
#include "CalculatorAsyncCallbackHandlers.h"
#include "CalculatorRequestReplySupport.h"
/*!
 * @brief This class represents a asynchronous task created to wait the reply of the procedure Calculator::addition from the server in an asynchronous call.
 * @ingroup CALCULATOR
 */
class Calculator_additionTask : public eprosima::rpc::transport::dds::DDSAsyncTask
{
    public:

        /**
         * \brief The default constructor.
         *
         * \param obj Object that implements the callbacks that FASTRPC will call when
         *            the reply will be received or and exception will be launched.
         * \param client Pointer to the server's proxy. Cannot be NULL.
         */
        Calculator_additionTask(Calculator_additionCallbackHandler &obj);

        /// \brief The default destructor.
        virtual ~Calculator_additionTask();
        
        virtual void execute();
        
        virtual void on_exception(const eprosima::rpc::exception::SystemException &ex);        

        
        /**
         * \brief This function returns the object used by the task.
         *
         * \return The object that implements the callbacks.
         */
        Calculator_additionCallbackHandler& getObject();

        virtual void* getReplyInstance();
        
        private:
        
        Calculator_additionCallbackHandler &m_obj;

        CalculatorReply m_reply;
};

/*!
 * @brief This class represents a asynchronous task created to wait the reply of the procedure Calculator::subtraction from the server in an asynchronous call.
 * @ingroup CALCULATOR
 */
class Calculator_subtractionTask : public eprosima::rpc::transport::dds::DDSAsyncTask
{
    public:

        /**
         * \brief The default constructor.
         *
         * \param obj Object that implements the callbacks that FASTRPC will call when
         *            the reply will be received or and exception will be launched.
         * \param client Pointer to the server's proxy. Cannot be NULL.
         */
        Calculator_subtractionTask(Calculator_subtractionCallbackHandler &obj);

        /// \brief The default destructor.
        virtual ~Calculator_subtractionTask();
        
        virtual void execute();
        
        virtual void on_exception(const eprosima::rpc::exception::SystemException &ex);        

        
        /**
         * \brief This function returns the object used by the task.
         *
         * \return The object that implements the callbacks.
         */
        Calculator_subtractionCallbackHandler& getObject();

        virtual void* getReplyInstance();
        
        private:
        
        Calculator_subtractionCallbackHandler &m_obj;

        CalculatorReply m_reply;
};


#endif // _Calculator_DDS_ASYNC_SUPPORT_H_