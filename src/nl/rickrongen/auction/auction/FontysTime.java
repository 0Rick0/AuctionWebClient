
package nl.rickrongen.auction.auction;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for fontysTime complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="fontysTime"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="seconds" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fontysTime", propOrder = {
    "seconds"
})
public class FontysTime {

    protected long seconds;

    /**
     * Gets the value of the seconds property.
     * 
     */
    public long getSeconds() {
        return seconds;
    }

    /**
     * Sets the value of the seconds property.
     * 
     */
    public void setSeconds(long value) {
        this.seconds = value;
    }

    @Override
    public String toString() {
        return "EPOCH{"+seconds+"}";
    }
}
