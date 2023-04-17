package airlineReservationSystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import airlineReservationSystem.dao.PassengerDao;
import airlineReservationSystem.entities.Passenger;

@Service
public class PassengerServicesImp implements PassengerServices {

	@Autowired
	private PassengerDao passengerDao;
	
	@Override
	public List<Passenger> getAllPassengers() {
		// TODO Auto-generated method stub
		return this.passengerDao.findAll();
	}

	@Override
	public Passenger findById(int passId) {
		// TODO Auto-generated method stub
		 Optional<Passenger> psg =  this.passengerDao.findById(passId);
		 Passenger psngr = psg.get();
		 return psngr;
	}

	@Override
	public void savePassenger(Passenger passenger) {
		// TODO Auto-generated method stub
		this.passengerDao.save(passenger);

	}

	@Override
	public void saveAllPassengers(List<Passenger> passengers) {
		// TODO Auto-generated method stub
		this.passengerDao.saveAll(passengers);
	}

	@Override
	public List<Passenger> getByUserIdAndDate(int userId, String flightDate) {
		// TODO Auto-generated method stub
		return this.passengerDao.findByUserIdAndDate(userId, flightDate);
	}

}
