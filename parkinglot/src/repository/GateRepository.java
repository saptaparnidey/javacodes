package repository;

import exception.GateNotFoundExceptioin;
import model.Gate;

import java.util.HashMap;

public class GateRepository {
    private HashMap<Integer, Gate> gateMap;

    public GateRepository() {
        this.gateMap = new HashMap<>();
    }

    public Gate get(int gateId) throws GateNotFoundExceptioin {
        Gate gate = gateMap.get(gateId);
        if(gate == null){
            throw new GateNotFoundExceptioin("Gate not found for Id : " + gateId);
        }
        return gate;
    }

    public Gate put(Gate gate){
        gateMap.put(gate.getId(), gate);
        return gate;
    }
}
