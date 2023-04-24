package com.example.GreenBone.SimpleCompany.service;

@Service
public class ComputerService {
    @Autowired
    private ComputerRepository computerRepository;

    public List<Computer> getAllComputers() {
        return computerRepository.findAll();
    }

    public Computer getComputerById(Long id) {
        return computerRepository.findById(id)
                .orElseThrow(() -> new ComputerNotFoundException(id));
    }

    public Computer createComputer(Computer computer) {
        return computerRepository.save(computer);
    }

    public Computer updateComputer(Long id, Computer computerDetails) {
        Computer computer = getComputerById(id);

        computer.setMake(computerDetails.getMake());
        computer.setModel(computerDetails.getModel());
        computer.setSerialNumber(computerDetails.getSerialNumber());

        return computerRepository.save(computer);
    }

    public void deleteComputer(Long id) {
        computerRepository.deleteById(id);
    }
