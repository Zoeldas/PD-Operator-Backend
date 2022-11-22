package com.example.authenticateuser.Entity;


import javax.persistence.*;

@Entity
@Table(name = "ditection_signal")
public class Signal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "signal_id")
    private int signal_id;


    @Column(name = "finger_tapping")
    private double finger_tapping;

    @Column(name = "hand_movement")
    private double hand_movement;

    @Column(name = "pronation_supination")
    private double pronation_supination;

    @Column(name = "time")
    private Long time;

    public int getSignal_id() {
        return signal_id;
    }

    public void setSignal_id(int signal_id) {
        this.signal_id = signal_id;
    }



    public double getFinger_tapping() {
        return finger_tapping;
    }

    public void setFinger_tapping(double finger_tapping) {
        this.finger_tapping = finger_tapping;
    }

    public double getHand_movement() {
        return hand_movement;
    }

    public void setHand_movement(double hand_movement) {
        this.hand_movement = hand_movement;
    }

    public double getPronation_supination() {
        return pronation_supination;
    }

    public void setPronation_supination(double pronation_supination) {
        this.pronation_supination = pronation_supination;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "{" +
                "finger_tapping:" + finger_tapping +
                ",hand_movement:" + hand_movement +
                ",pronation_supination:" + pronation_supination +
                ",time:" + time +
                "}";
    }

    public String collectData(){
        return finger_tapping + "," +
               hand_movement + "," +
               pronation_supination + "," +
               time;
    }
}
