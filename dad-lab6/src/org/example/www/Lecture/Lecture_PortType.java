/**
 * Lecture_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.example.www.Lecture;

public interface Lecture_PortType extends java.rmi.Remote {
    public java.lang.String fnGetHelloClass(java.lang.String strSubjectCode) throws java.rmi.RemoteException;
    public java.lang.String fnGetNumStudents(java.lang.String strSubjectCode) throws java.rmi.RemoteException;
    public void fnGetStudInfo(java.lang.String strStudentID, javax.xml.rpc.holders.StringHolder strStudName, javax.xml.rpc.holders.StringHolder strStudGender, javax.xml.rpc.holders.StringHolder strStudGroup, org.apache.axis.holders.DateHolder studYearBirth, javax.xml.rpc.holders.FloatHolder fltStudCGPA) throws java.rmi.RemoteException;
    public void fnGetStudQuery(java.lang.String strLogin, javax.xml.rpc.holders.StringHolder strFirstName, javax.xml.rpc.holders.StringHolder strLastName, javax.xml.rpc.holders.StringHolder strUserLvl, javax.xml.rpc.holders.StringHolder strLastLogin) throws java.rmi.RemoteException;
}
