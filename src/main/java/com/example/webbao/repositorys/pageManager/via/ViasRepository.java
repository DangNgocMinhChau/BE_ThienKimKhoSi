package com.example.webbao.repositorys.pageManager.via;

import com.example.webbao.models.pageManager.devices.Devices;
import com.example.webbao.models.pageManager.via.Vias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ViasRepository extends JpaRepository<Vias,Long> {
    @Query(value = "select type_apps from thienkimkhosi.vias where device = ?1", nativeQuery =  true)
    List<String> findAppByIdDevices(Long id);
}
