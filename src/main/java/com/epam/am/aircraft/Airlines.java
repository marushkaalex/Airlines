package com.epam.am.aircraft;

import java.util.ArrayList;
import java.util.List;

public class Airlines {
    private final long id;
    private String name;
    private List<Plane> planes;

    public Airlines(long id, String name) {
        this.id = id;
        this.name = name;
        planes = new ArrayList<Plane>();
    }

    public Airlines(long id, String name, List<Plane> planes) {
        this.id = id;
        this.name = name;
        this.planes = planes;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Plane> getPlanes() {
        return planes;
    }

    public void setPlanes(List<Plane> planes) {
        this.planes = planes;
    }

    public void addPlane(Plane plane) {
        for (Plane p : planes) {
            if (p.getId() == plane.getId()) return;
        }
        planes.add(plane);
    }

    public Plane getPlaneById(long id) {
        for (Plane plane : planes) {
            if (plane.getId() == id) return plane;
        }
        return null;
    }

    public List<String> getPlanesInfo() {
        List<String> list = new ArrayList<String>();
        for (Plane plane : planes) {
            list.add(plane.getManufacturer() + " " + plane.getModel() + " id = " + plane.getId());
        }
        return list;
    }

    @Override
    public String toString() {
        return "Airlines{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", planes=" + planes +
                '}';
    }
}
