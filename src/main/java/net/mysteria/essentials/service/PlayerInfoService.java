package net.mysteria.essentials.service;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import net.mysteria.essentials.model.PlayerInfoModel;
import net.mysteria.essentials.persistence.PlayerInfoEntity;

public class PlayerInfoService {
	private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
			.createEntityManagerFactory("mysteria_essentials");

	public static void addPlayerInfo(PlayerInfoModel player) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = null;
		PlayerInfoEntity playerInfo = new PlayerInfoEntity();

		try {
			et = em.getTransaction();
			et.begin();
			playerInfo.setFirstTimeSeen(player.getFirstTimeSeen());
			playerInfo.setUsername(player.getUsername());
			playerInfo.setLastTimeSeen(player.getLastTimeSeen());
			em.persist(playerInfo);
			et.commit();
		} catch (Exception e) {
			if (et != null) {
				et.rollback();
			}
		} finally {
			em.close();
		}

	}

	public static PlayerInfoModel getPlayerByUsername(String username) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		String query = "SELECT u FROM PlayerInfoEntity u WHERE u.username = :username";

		TypedQuery<PlayerInfoEntity> tq = em.createQuery(query, PlayerInfoEntity.class);
		PlayerInfoEntity result = new PlayerInfoEntity();
		tq.setParameter("username", username);
		try {
			result = tq.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}

		PlayerInfoModel player = new PlayerInfoModel();

		player.setFirstTimeSeen(result.getFirstTimeSeen());
		player.setLastTimeSeen(result.getLastTimeSeen());
		player.setUsername(username);

		return player;

	}

	private static PlayerInfoEntity getPlayerEntityByUsername(String username) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		String query = "SELECT u FROM PlayerInfoEntity u WHERE u.username = :username";

		TypedQuery<PlayerInfoEntity> tq = em.createQuery(query, PlayerInfoEntity.class);
		PlayerInfoEntity result = new PlayerInfoEntity();
		tq.setParameter("username", username);
		try {
			result = tq.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}

		return result;

	}

	public static void updateLastTimeSeen(String username, String lts) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = null;
		PlayerInfoEntity playerInfo = getPlayerEntityByUsername(username);
		
		try {
			et = em.getTransaction();
			et.begin();
			playerInfo.setLastTimeSeen(lts);
			em.merge(playerInfo);
			et.commit();
		} catch (Exception e) {
			if(et != null) {
				et.rollback();
			}
		} finally {
			em.close();
		}
		
	}
	
}

