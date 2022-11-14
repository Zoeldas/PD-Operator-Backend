package com.example.authenticateuser.Entity;


import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "ditection_signal")
public class Signal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "signal_id")
    private int signal_id;


    @Column(name = "finger_tapping")
    private int finger_tapping;

    @Column(name = "hand_movement")
    private int hand_movement;

    @Column(name = "pronation_supination")
    private int pronation_supination;

    @Column(name = "time")
    private Timestamp time;

    public int getSignal_id() {
        return signal_id;
    }

    public void setSignal_id(int signal_id) {
        this.signal_id = signal_id;
    }



    public int getFinger_tapping() {
        return finger_tapping;
    }

    public void setFinger_tapping(int finger_tapping) {
        this.finger_tapping = finger_tapping;
    }

    public int getHand_movement() {
        return hand_movement;
    }

    public void setHand_movement(int hand_movement) {
        this.hand_movement = hand_movement;
    }

    public int getPronation_supination() {
        return pronation_supination;
    }

    public void setPronation_supination(int pronation_supination) {
        this.pronation_supination = pronation_supination;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Signal{" +
                "signal_id=" + signal_id +
                ", finger_tapping=" + finger_tapping +
                ", hand_movement=" + hand_movement +
                ", pronation_supination=" + pronation_supination +
                ", time=" + time +
                '}';
    }
}
