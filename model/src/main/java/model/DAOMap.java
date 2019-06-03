package model;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Entity;
import entity.Map;
import model.DBConnection;


/* The Class DAOMap.
 *
 * @author Jean-Aymeric Diet
 */
class DAOMap extends DAOEntity {
	
    /* Instantiates a new DAO hello world.
     *
     * @param connection
     *          the connection
     * @throws SQLException
     *           the SQL exception
     */
    public DAOMap(final Connection connection) throws SQLException {
        super(connection);
    }
    
    /* (non-Javadoc)
     *
     * @see model.DAOEntity#find(int)
     */
   
    final ResultSet resultSet;
    public int map_number = 1;
    public Map find(final int id) {
       

        try {
            final String sql = "SELECT map FROM map WHERE id ="+ map_number ;
            final CallableStatement call = this.getConnection().prepareCall(sql);
            call.execute();
            if (resultSet.next()) {
                try {
					this.resultSet;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    

    
	@Override
	public boolean create(Entity entity) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean delete(Entity entity) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean update(Entity entity) {
		// TODO Auto-generated method stub
		return false;
	}
    
    }
