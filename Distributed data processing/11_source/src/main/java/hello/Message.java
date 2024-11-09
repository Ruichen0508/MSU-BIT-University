package hello;

public class Message {
    public String address;
    public String wsdl;
    public String implementationClass;

    public Message(){
    }

    public String getAddress() {
        return this.address;
    }

    void setAddress(String address) {
        this.address = address;
    }

    public String getWsdl() {
        return this.wsdl;
    }

    void setWsdl(String wsdl) {
        this.wsdl = wsdl;
    }

    public String getImplementationClass() {
        return this.implementationClass;
    }

    void setImplementationClass(String implementationClass) {
        this.implementationClass = implementationClass;
    }

    public String toString(){
        return "Address: " + this.address + "\nWSDL: " + this.wsdl + "\nImplementation class: " + this.implementationClass;
    }
}
