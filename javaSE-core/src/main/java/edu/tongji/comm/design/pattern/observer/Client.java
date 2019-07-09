package edu.tongji.comm.design.pattern.observer;

import edu.tongji.comm.design.pattern.observer.api.Observer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author chenkangqiang
 * @date 2017/8/28
 * @Description
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"src/main/resources/application-context.xml"})
public class Client {

    @Autowired
    private WeatherData weatherData;

    @Test
    public void test() {
        Observer currentConditionDisplay = new CurrentConditionDisplay();
        Observer forecastConditionDisplay = new ForecastConditionDisplay();
        weatherData.registerObserver(currentConditionDisplay);
        weatherData.registerObserver(forecastConditionDisplay);
        weatherData.setTemperature(37.0F);
        weatherData.setHumidity(0.58F);
        weatherData.setPressure(100000F);
        weatherData.setChanged(true);
        weatherData.notifyObserver();
    }



}
