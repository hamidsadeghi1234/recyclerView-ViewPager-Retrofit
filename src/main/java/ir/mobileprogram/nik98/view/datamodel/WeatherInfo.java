package ir.mobileprogram.nik98.view.datamodel;

public class WeatherInfo {
    private  String weatherName;
    private  String weatherDescription;
    private  float windSpeed;
    private  float windDegree;
    private  int humidity;
    private  float weatherTemperature;
    private  float minTemperature;
    private  float maxTemperature;
    private  int pressure;

    public String getWeatherName() {
        return weatherName;
    }

    public void setWeatherName(String weatherName) {
        this.weatherName = weatherName;
    }

    public String getWetherDescription() {
        return weatherDescription;
    }

    public void setWetherDescription(String wetherDescription) {
        this.weatherDescription = wetherDescription;
    }

    public float getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(float windSpeed) {
        this.windSpeed = windSpeed;
    }

    public float getWindDegree() {
        return windDegree;
    }

    public void setWindDegree(float windDegree) {
        this.windDegree = windDegree;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public float getWeatherTemperature() {
        return weatherTemperature;
    }

    public void setWeatherTemperature(float weatherTemperature) {
        this.weatherTemperature = weatherTemperature;
    }

    public float getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(float minTemperature) {
        this.minTemperature = minTemperature;
    }

    public float getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(float maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }
}
