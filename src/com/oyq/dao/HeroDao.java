package com.oyq.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.oyq.entity.Hero;
import com.oyq.utils.JDBCUtilsSuper;
import com.sun.org.apache.regexp.internal.recompile;

public class HeroDao {
	public int insertHero(Hero hero) throws SQLException{
		Connection con = JDBCUtilsSuper.getConnection();
		String sql = "insert into hero(name,hp,damage) value(?,?,?)";
		PreparedStatement preSta = con.prepareStatement(sql);
		preSta.setString(1, hero.getName());
		preSta.setDouble(1, hero.getHp());
		preSta.setInt(1, hero.getDamage());
		return preSta.executeUpdate();
	}
	public int deleteHeroById(int id) throws SQLException{
		Connection con = JDBCUtilsSuper.getConnection();
		String sql = "delete from hero where id = ?";
		PreparedStatement preSta = con.prepareStatement(sql);
		preSta.setInt(1, id);
		return preSta.executeUpdate();
	}
	public int updateHero(Hero hero) throws SQLException{
		Connection con = JDBCUtilsSuper.getConnection();
		String sql = "update hero set name=?,hp=?,damage=? where id=?";
		PreparedStatement preSta = con.prepareStatement(sql);
		preSta.setString(1, hero.getName());
		preSta.setDouble(2, hero.getHp());
		preSta.setInt(3, hero.getDamage());
		preSta.setInt(4, hero.getId());
		return preSta.executeUpdate();
	}
	public List<Hero> listHero() throws SQLException{
		Connection con = JDBCUtilsSuper.getConnection();
		String sql = "select id,name,hp,damage from hero";
		Statement sta = con.createStatement();
		ResultSet rs = sta.executeQuery(sql);
		List<Hero> heros = new ArrayList<>();
		while (rs.next()) {
			Hero hero = new Hero();
			hero.setId(rs.getInt("id"));
			hero.setName(rs.getString("name"));
			hero.setDamage(rs.getInt("damage"));
			hero.setHp(rs.getDouble("hp"));
			heros.add(hero);
		}
		return heros;
	}
	public Hero getHeroById(int id) throws SQLException{
		Connection con = JDBCUtilsSuper.getConnection();
		String sql = "select id,name,hp,damage from hero where id=?";
		PreparedStatement preSta = con.prepareStatement(sql);
		preSta.setInt(1, id);
		ResultSet rs = preSta.executeQuery();
		Hero hero = null;
		while (rs.next()) {
			hero = new Hero();
			hero.setId(rs.getInt("id"));
			hero.setName(rs.getString("name"));
			hero.setDamage(rs.getInt("damage"));
			hero.setHp(rs.getDouble("hp"));
		}
		return hero;
	}
}
