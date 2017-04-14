package com.orozco.netreport.model;

import android.content.Context;
import android.location.Location;
import android.text.TextUtils;

import com.github.pwittchen.reactivenetwork.library.Connectivity;
import com.orozco.netreport.R;


/**
 * Paul Sydney Orozco (@xtrycatchx) on 4/2/17.
 */

public class Data {

    private Connectivity connectivity;
    private Location location;
    private String operator;
    private Device device;
    private String imei;
    private String signal;
    private String bandwidth;
    private String version;

    private Data() {
        // prevent direct initialization
    }

    public Data(Connectivity connectivity, Location location, String operator, Device device, String imei, String signal, String bandwidth, String version) {
        this.connectivity = connectivity;
        this.location = location;
        this.operator = operator;
        this.device = device;
        this.imei = imei;
        this.signal = signal;
        this.bandwidth = bandwidth;
        this.version = version;
    }

    private Data(Builder builder) {
        connectivity = builder.connectivity;
        location = builder.location;
        operator = builder.operator;
        device = builder.device;
        imei = builder.imei;
        signal = builder.signal;
        bandwidth = builder.bandwidth;
        version = builder.version;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(Data copy) {
        Builder builder = new Builder();
        builder.connectivity = copy.connectivity;
        builder.location = copy.location;
        builder.operator = copy.operator;
        builder.device = copy.device;
        builder.imei = copy.imei;
        builder.signal = copy.signal;
        builder.bandwidth = copy.bandwidth;
        builder.version = copy.version;
        return builder;
    }


    public Connectivity getConnectivity() {
        return connectivity;
    }

    public Location getLocation() {
        return location;
    }

    public String getOperator() {
        return operator;
    }

    public Device getDevice() {
        return device;
    }

    public String getImei() {
        return imei;
    }

    public String getSignal() {
        return signal;
    }

    public String getBandwidth() {
        return bandwidth;
    }

    public String getVersion() {return version; }

    public static final class Builder {
        private Connectivity connectivity;
        private Location location;
        private String operator;
        private Device device;
        private String imei;
        private String signal;
        private String bandwidth;
        private String version;

        private Builder() {
        }

        public Builder withConnectivity(Connectivity val) {
            connectivity = val;
            return this;
        }

        public Builder withLocation(Location val) {
            location = val;
            return this;
        }

        public Builder withOperator(String val) {
            operator = val;
            return this;
        }

        public Builder withDevice(Device val) {
            device = val;
            return this;
        }

        public Builder withImei(String val) {
            imei = val;
            return this;
        }

        public Builder withSignal(String val) {
            signal = val;
            return this;
        }

        public Builder withBandwidth(String val) {
            bandwidth = val;
            return this;
        }
        public Builder withVersion(String val) {
            version = val;
            return this;
        }

        public Data build() {
            return new Data(this);
        }
    }

    public String toString(Context context) {
        StringBuilder sb = new StringBuilder();
        if(!TextUtils.isEmpty(getOperator())) {
            sb.append(context.getString(R.string.provider));
            sb.append(getOperator());
            sb.append("\n");
        }
        if(!TextUtils.isEmpty(getBandwidth())) {
            sb.append(context.getString(R.string.bandwidth));
            float bandwidth = Float.valueOf(getBandwidth().replace(" Kbps",""));
            String bandwidthString;
            if(bandwidth < 1024) {
                bandwidthString = String.valueOf(bandwidth).concat(" Kbps");
            }
            else {

                bandwidthString = String.valueOf(Math.round((bandwidth/1024)*100.0)/100.0).concat(" Mbps");
            }
            sb.append(bandwidthString);

            sb.append("\n");
        }
        if(!TextUtils.isEmpty(getSignal())) {
            sb.append(context.getString(R.string.signal));
            sb.append(getSignal());
        }
        return sb.toString();
    }


}
