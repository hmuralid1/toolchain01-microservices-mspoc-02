package demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import demo.domain.Player;
import demo.domain.Team;
import demo.repository.TeamRepository;

@SpringBootApplication
public class Application {

	@Autowired TeamRepository teamRepository;
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @PostConstruct
	public void init() {
		List<Team> list = new ArrayList<>();

		Set<Player> set = new HashSet<>();
		set.add(new Player("MSPOC02", "Showman"));
		set.add(new Player("Buckets", "Guard"));
		set.add(new Player("Dizzy", "Guard"));
		set.add(new Player("MS Dhoni", "Captain"));
		
		list.add(new Team("MSPOC02", "Globetrotters", set));
		list.add(new Team("Washington","Generals",null));

		teamRepository.save(list);
	}    
    
}
