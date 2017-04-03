/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: D:\\AndroidWorkSpace\\Silvassa\\jobdispatcher\\src\\main\\aidl\\com\\google\\android\\gms\\gcm\\INetworkTaskCallback.aidl
 */
package com.google.android.gms.gcm;
/**
 * Provide a callback for a {@link JobService} to notify the FirebaseJobDispatcher that
 * it's finished.
 *
 * @hide
 */
public interface INetworkTaskCallback extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.google.android.gms.gcm.INetworkTaskCallback
{
private static final java.lang.String DESCRIPTOR = "com.google.android.gms.gcm.INetworkTaskCallback";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.google.android.gms.gcm.INetworkTaskCallback interface,
 * generating a proxy if needed.
 */
public static com.google.android.gms.gcm.INetworkTaskCallback asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.google.android.gms.gcm.INetworkTaskCallback))) {
return ((com.google.android.gms.gcm.INetworkTaskCallback)iin);
}
return new com.google.android.gms.gcm.INetworkTaskCallback.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_taskFinished:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.taskFinished(_arg0);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.google.android.gms.gcm.INetworkTaskCallback
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@Override public void taskFinished(int result) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(result);
mRemote.transact(Stub.TRANSACTION_taskFinished, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_taskFinished = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
}
public void taskFinished(int result) throws android.os.RemoteException;
}
