package de.tekup.summer.project.service;

import java.util.List;

import de.tekup.summer.project.model.client;



public interface IServiceClient {
	public List<client> getAllclients();
	public client getclient(int id);
	public client save(client client);
	public void deleteclient(int id);
	public client Updateclient(client client, int id);
	public client findAllByEmail(String email); 
	public client findAllByEmailAndPassword(String email,String password); 
}
