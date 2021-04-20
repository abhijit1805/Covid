package com.example.covichart;

public class Record{
    String _timeStamp,_temperature,_oxygen,_pulse;

    public Record(String _timeStamp, String _temperature, String _oxygen, String _pulse) {
        this._timeStamp = _timeStamp;
        this._temperature = _temperature;
        this._oxygen = _oxygen;
        this._pulse = _pulse;
    }

    public String get_timeStamp() {
        return _timeStamp;
    }

    public void set_timeStamp(String _timeStamp) {
        this._timeStamp = _timeStamp;
    }

    public String get_temperature() {
        return _temperature;
    }

    public void set_temperature(String _temperature) {
        this._temperature = _temperature;
    }

    public String get_oxygen() {
        return _oxygen;
    }

    public void set_oxygen(String _oxygen) {
        this._oxygen = _oxygen;
    }

    public String get_pulse() {
        return _pulse;
    }

    public void set_pulse(String _pulse) {
        this._pulse = _pulse;
    }
}