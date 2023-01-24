package com.ingsw.backend.Controllers;

import com.ingsw.backend.Model.Category;
import com.ingsw.backend.Model.DTO.TableRestaurantDTO;
import com.ingsw.backend.Model.TableRestaurant;
import com.ingsw.backend.Service.Interface.ITableRestaurantService;
import jakarta.persistence.Table;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tablerestaurant")
public class TableRestaurantController {

    @Autowired
    @Qualifier("mainTableRestaurantService")
    private ITableRestaurantService tableRestaurantService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/get/{name}")
    public List<TableRestaurantDTO> getByRestaurantName(@PathVariable String name){
        List<TableRestaurant> tableRestaurantList = tableRestaurantService.getByRestaurantName(name);

        List<TableRestaurantDTO> tableRestaurantDTOS = new ArrayList<>();
        for (TableRestaurant tableRestaurant: tableRestaurantList) {
            tableRestaurantDTOS.add(convertDTO(tableRestaurant));
        }

        return tableRestaurantDTOS;
    }

    @GetMapping("/get/{name}/{id}")
    public TableRestaurantDTO findByRestaurantNameAndId(@PathVariable String name, @PathVariable Integer id){
        TableRestaurant tableRestaurant = tableRestaurantService.findByRestaurantNameAndId(name, id);

        TableRestaurantDTO tableRestaurantDTO = new TableRestaurantDTO();
        tableRestaurantDTO = convertDTO(tableRestaurant);

        return  tableRestaurantDTO;
    }

    @GetMapping("/count/total/{name}")
    public Long countByRestaurantName(@PathVariable String name){
        return tableRestaurantService.countByRestaurantName(name);
    }

    private TableRestaurantDTO convertDTO(TableRestaurant tableRestaurant) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        TableRestaurantDTO tableRestaurantDTO = new TableRestaurantDTO();
        tableRestaurantDTO = modelMapper.map(tableRestaurant, TableRestaurantDTO.class);

        String restaurant_name = tableRestaurant.getRestaurant().getName();
        tableRestaurantDTO.setRestaurantName(restaurant_name);

        Integer id = tableRestaurant.getId();
        tableRestaurantDTO.setId(id);

        Integer seats = tableRestaurant.getSeats();
        tableRestaurantDTO.setSeats(seats);

        return tableRestaurantDTO;
    }
}
