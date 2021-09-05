package de.tekup.summer.project.service;


import java.util.List;

import org.springframework.stereotype.Service;

import de.tekup.summer.project.model.client;
import de.tekup.summer.project.repository.ClientRepository;
@Service
public class ServiceClient implements IServiceClient{

	
	private ClientRepository RepoClient;
	
	public ServiceClient(ClientRepository repoClient) {
		super();
		RepoClient = repoClient;
	}

	@Override
	public List<client> getAllclients() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public client getclient(int id) {
		// TODO Auto-generated method stub
		return RepoClient.getById(id);
	}

	@Override
	public client save(client client) {
		return RepoClient.save(client);
	}

	@Override
	public void deleteclient(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public client Updateclient(client client, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public client findAllByEmail(String email) {
		// TODO Auto-generated method stub
		return RepoClient.findAllByEmail(email);
	}

	@Override
	public client findAllByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		return RepoClient.findAllByEmailAndPassword(email, password);
	}
	
	

}
