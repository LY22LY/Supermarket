package SupermarketCashRegister;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import com.bean.GoodsClass;
import com.bean.GoodsClass1;
import com.dao.DaoGoodsClass;
import com.dao.DaoGoodsClass1;


public class LeibieJpanel extends JPanel implements ActionListener, MouseListener {
	private JPanel jp_kongbai;
	private JPanel jp_shangpinleibie;
	private JPanel jp_leibieweihu;
	private JLabel jl_leibiemingcheng;
	private JTextField jf_leibiemingcheng;
	private JLabel jl_leibiemingcheng2;
	private JTextField jf_leibiemingcheng2;
	JButton jb_chaxun;
	JButton jb_tianjia;
	JButton jb_xiugai;
	JButton jb_shanchu;
	JButton jb_qingkong;
	JTable jt_leibie;
	private String cid;
	private String cname;
	DefaultTableModel model;
	private ArrayList<GoodsClass1> list;

	private DaoGoodsClass1 daoGC = new DaoGoodsClass1();

	// 构造方法
	public LeibieJpanel() {
		initGUI();
	}

	// 界面初始化方法
	public void initGUI() {
		// 对卡片做整体设置：最佳大小，布局
		this.setPreferredSize(new Dimension(730, 550));

		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);

		// 空白
		{
			jp_kongbai = new JPanel();
			jp_kongbai.setPreferredSize(new Dimension(325, 90));
			jp_kongbai.setLayout(null);
			this.add(jp_kongbai, BorderLayout.NORTH);
		}

		// 商品类别
		{
			jp_shangpinleibie = new JPanel();
			jp_shangpinleibie.setPreferredSize(new Dimension(360, 30));
			jp_shangpinleibie.setLayout(null);
			// 设置边框

			TitledBorder tb = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE), "商品类别");

			tb.setTitleColor(Color.BLUE);

			jp_shangpinleibie.setBorder(tb);

			this.add(jp_shangpinleibie, BorderLayout.WEST);

			// 放置关键字标签
			jl_leibiemingcheng = new JLabel();
			jl_leibiemingcheng.setText("类别名称：");
			jl_leibiemingcheng.setBounds(24, 25, 176, 20);
			jp_shangpinleibie.add(jl_leibiemingcheng);
			// 放置关键字文本框
			jf_leibiemingcheng = new JTextField();
			jf_leibiemingcheng.setBounds(100, 25, 120, 25);
			jp_shangpinleibie.add(jf_leibiemingcheng);

			// 查询按钮
			jb_chaxun = new JButton();
			jb_chaxun.setText("查询");
			jb_chaxun.setBounds(250, 25, 60, 25);
			jp_shangpinleibie.add(jb_chaxun);
			jb_chaxun.addActionListener(this);

			// 类别列表
			{
				// 设置滚动面板
				JScrollPane jsp_leibie = new JScrollPane();
				jsp_leibie.setBounds(5, 55, 350, 350);
				jp_shangpinleibie.add(jsp_leibie);

				// 设置查询列表，JTable
				// 1.创建TableModel
				model = new DefaultTableModel(null, new String[] { "类别编号", "类别名称" });
				// 2.创建列表
				jt_leibie = new JTable(model);
				jt_leibie.addMouseListener(this);

				// 查询全部用户数据
				list = daoGC.selectAll();

				if (list.size() == 0) {

					JOptionPane.showMessageDialog(null, "系统用户不存在");
				} else {
					for (int i = 0; i < list.size(); i++) {
						GoodsClass1 user = list.get(i);
						String[] rowData = { user.getCid(), user.getCName() };

						model.addRow(rowData);//将数据放到表格中
					}
				}

				// 3.将列表放到滚动面板中
				jsp_leibie.setViewportView(jt_leibie);

				jt_leibie.addMouseListener(new MouseListener() {

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub

					}
				});
			}
		}
		// 类别维护
		{
			jp_leibieweihu = new JPanel();
			jp_leibieweihu.setPreferredSize(new Dimension(350, 30));
			jp_leibieweihu.setLayout(null);
			// 设置边框
			TitledBorder tb2 = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE), "类别维护");

			tb2.setTitleColor(Color.BLUE);

			jp_leibieweihu.setBorder(tb2);

			this.add(jp_leibieweihu, BorderLayout.EAST);

			// 放置类别标签
			jl_leibiemingcheng2 = new JLabel();
			jl_leibiemingcheng2.setText("类别名称：");
			jl_leibiemingcheng2.setBounds(24, 25, 176, 20);
			jp_leibieweihu.add(jl_leibiemingcheng2);
			// 放置类别文本框
			jf_leibiemingcheng2 = new JTextField();
			jf_leibiemingcheng2.setBounds(100, 25, 180, 25);
			jp_leibieweihu.add(jf_leibiemingcheng2);

			// 添加按钮
			jb_tianjia = new JButton();
			jb_tianjia.setText("添加类别");
			jb_tianjia.setBounds(30, 125, 100, 25);
			jp_leibieweihu.add(jb_tianjia);
			jb_tianjia.addActionListener(this);

			// 修改按钮
			jb_xiugai = new JButton();
			jb_xiugai.setText("修改类别");
			jb_xiugai.setBounds(200, 125, 100, 25);
			jp_leibieweihu.add(jb_xiugai);
			jb_xiugai.addActionListener(this);
			// 删除按钮
			jb_shanchu = new JButton();
			jb_shanchu.setText("删除类别");
			jb_shanchu.setBounds(30, 280, 100, 25);
			jp_leibieweihu.add(jb_shanchu);
			jb_shanchu.addActionListener(this);

			// 清空按钮
			jb_qingkong = new JButton();
			jb_qingkong.setText("清空类别");
			jb_qingkong.setBounds(200, 280, 100, 25);
			jp_leibieweihu.add(jb_qingkong);
			jb_qingkong.addActionListener(this);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		// 1.获取表格中这一行的数据
		// 获取表格中被选中的行号
		int row = jt_leibie.getSelectedRow();
		String cname = jt_leibie.getValueAt(row, 1).toString();
		// String cid=jt_leibie.getValueAt(row, 1).toString();

		// 通过name查询用户
		GoodsClass1 user = daoGC.selectByName(cname);

		// 将数据放到右侧的控件中
		jf_leibiemingcheng2.setText(cname);

		jf_leibiemingcheng2.setEditable(true);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o == jb_chaxun) {
			for (int i = model.getRowCount() - 1; i >= 0; i--) {
				model.removeRow(i);   //清空列表内容
			}

			// 获取查询信息
			String info = jf_leibiemingcheng.getText();

			// 如果info是空的，显示所有数据，如果不是空的，那就模糊查询
			if (info.equals("")) {
				// 查询全部用户数据
				list = daoGC.selectAll();//通过查询全部的方法把查询到的数据放到list集合中

				if (list.size() == 0) {

					JOptionPane.showMessageDialog(null, "系统用户不存在");
				} else {
					for (int i = 0; i < list.size(); i++) {
						GoodsClass1 user = list.get(i);
						String[] rowData = { user.getCid(), user.getCName() };

						model.addRow(rowData);//将数据放到表格中
					}
				}
			} else {
				// 模糊查询
				list = daoGC.selectLeibie(info);//通过模糊查询的方法把查询到的数据放到list集合中
				if (list.size() == 0) {

					JOptionPane.showMessageDialog(null, "没有要查询的信息");
				} else {
					for (int i = 0; i < list.size(); i++) {
						GoodsClass1 user = list.get(i);
						String[] rowData = { user.getCid(), user.getCName() };

						model.addRow(rowData);//将数据放到表格中
					}
				}
			}
		}

		if (o == jb_tianjia) {

			// 1.获取类别信息
			String cname = jf_leibiemingcheng2.getText(); // 获取类别名

			// 2判断cname是否为空
			if (cname.equals("")) {
				JOptionPane.showMessageDialog(null, "类别名称不能为空");

			} else {
				// 3.判断id是否存在，如果存在则提示用户，否则可以进行插入
				// 调用控制层的相关方法判断cname是否存在
				GoodsClass1 gc = daoGC.selectByName(cname);
				if (gc == null) {
					// 4.如果id不存在，进行添加操作

					GoodsClass1 newUser = new GoodsClass1(cid, cname);

					boolean flag = daoGC.insertgc(newUser);

					// 判断flag值，是否插入成功
					if (flag) {
						JOptionPane.showMessageDialog(null, "插入成功");
					} else {
						JOptionPane.showMessageDialog(null, "插入失败");
					}
				}else {
					JOptionPane.showMessageDialog(null, "此类别已存在");
				}

			}

			// 查询全部用户数据
			list = daoGC.selectAll();
			for (int i = model.getRowCount() - 1; i >= 0; i--) {
				model.removeRow(i);
			}
			if (list.size() == 0) {

				JOptionPane.showMessageDialog(null, "系统用户不存在");
			} else {
				for (int i = 0; i < list.size(); i++) {
					GoodsClass1 user = list.get(i);
					String[] rowData = { user.getCid(), user.getCName() };

					model.addRow(rowData);
				}
			}

		}
		// 修改用户
		if (o == jb_xiugai) {
			// 1.获取用户信息
			String cname = jf_leibiemingcheng2.getText(); // 获取用户名
			if (cname.equals("")) {

				JOptionPane.showMessageDialog(null, "类别名不能为空");
			}else {
				int row = jt_leibie.getSelectedRow();


				// 2.判断id、用户名是否为空
				if (row<0) {

					JOptionPane.showMessageDialog(null, "请点击左侧数据");
				} else {
					String cid = jt_leibie.getValueAt(row, 0).toString();
					int user = daoGC.updategc(cid, cname);
					JOptionPane.showMessageDialog(null, "修改成功");
				}
			}
			// 查询全部用户数据
			list = daoGC.selectAll();
			for (int i = model.getRowCount() - 1; i >= 0; i--) {
				model.removeRow(i);
			}
			if (list.size() == 0) {

				JOptionPane.showMessageDialog(null, "系统用户不存在");
			} else {
				for (int i = 0; i < list.size(); i++) {
					GoodsClass1 user = list.get(i);
					String[] rowData = { user.getCid(), user.getCName() };

					model.addRow(rowData);
				}
			}

		}

		if (o == jb_shanchu) {
			// 1.获取用户信息
			// String uname = jTextField2.getText(); // 获取用户名
			cname = jf_leibiemingcheng2.getText(); // 获取类别名
			if (cname.equals("")) {

				JOptionPane.showMessageDialog(null, "请点击左侧列表的数据");
			}else {

				cname = jf_leibiemingcheng2.getText(); // 获取类别名
				// int row = jt_leibie.getSelectedRow();
				// String cid=jt_leibie.getValueAt(row, 0).toString();

				int user = daoGC.deletegc(cname);
				JOptionPane.showMessageDialog(null, "删除成功");
			}
			// 查询全部用户数据
			list = daoGC.selectAll();
			for (int i = model.getRowCount() - 1; i >= 0; i--) {
				model.removeRow(i);
			}
			if (list.size() == 0) {

				JOptionPane.showMessageDialog(null, "系统用户不存在");
			} else {
				for (int i = 0; i < list.size(); i++) {
					GoodsClass1 user1 = list.get(i);
					String[] rowData = { user1.getCid(), user1.getCName() };

					model.addRow(rowData);
				}
			}

		}
		if (o == jb_qingkong) {
			jf_leibiemingcheng2.setText(null);

		}
	}
}