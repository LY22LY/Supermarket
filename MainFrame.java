package SupermarketCashRegister;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: JinHe
 * @Date: 2020/6/8
 **/

public class MainFrame extends JFrame implements ItemListener {
    private Container con;
    private JRadioButton jrb_shouyin;
    private JRadioButton jrb_yonghu;
    private JRadioButton jrb_huiyuan;
    private JRadioButton jrb_leibie;
    private JRadioButton jrb_danwei;
    private JRadioButton jrb_jinhuo;
    private JRadioButton jrb_shangpin;
    private JRadioButton jrb_yingye;
    private JRadioButton jrb_gonghuo;
    private JRadioButton jrb_guanyu;
    private CardLayout cardLayout;
    private JPanel jp_center;


    public MainFrame() {
        initGUI();
    }

    // 用来界面调试，后期会删掉
//    public static void main(String[] args) {
//        MainFrame mf = new MainFrame();
//        mf.setLocationRelativeTo(null); // 显示在屏幕的中间
//        mf.setVisible(true);
//    }

    // 界面初始化
    public void initGUI() {
        // 界面的整体设置
        setSize(850, 700);
        setTitle("超市收银管理系统");
        this.setResizable(false); // 禁止最大化
        con = getContentPane();// 获取内容对象
        // 北面：logo图片的放置
        {
//          JPanel jp_noth = new JPanel();
            JLabel jl_logo = new JLabel();
            jl_logo.setPreferredSize(new Dimension(850, 110)); // 最佳大小
            jl_logo.setIcon(new ImageIcon("src/images/mainlogo.jpg"));
//          jp_noth.add(jl_logo);
//          con.add(jp_noth,BorderLayout.NORTH);
            con.add(jl_logo, BorderLayout.NORTH);
        }

        // 南面：三个jl（下方文字）
        {
            //定义小箱子
            JPanel jp_south = new JPanel();
            jp_south.setPreferredSize(new Dimension(850, 40));
            // 定义三个jl
            JLabel jl_info = new JLabel();
            jl_info.setText("欢迎使用超市收银系统");
            JLabel jl_datetime = new JLabel();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date date = new Date();
            String datetime = format.format(date);
            jl_datetime.setText("当前的时间" + datetime);
            jl_datetime.setText("当前时间" + format.format(new Date()));
            JLabel jl_role = new JLabel();
            jl_role.setText("admin");

            jp_south.add(jl_info);
            jp_south.add(jl_datetime);
            jp_south.add(jl_role);

            con.add(jp_south, BorderLayout.SOUTH);
        }

        // 西面: 功能实现
        {
            JPanel jp_west = new JPanel();
            jp_west.setPreferredSize(new Dimension(115, 550));
            // 按钮组对象
            ButtonGroup group = new ButtonGroup();
            // 定义单选按钮
            jrb_shouyin = new JRadioButton();
            jrb_shouyin.setIcon(new ImageIcon("src/images/shouyin.jpg"));
            jrb_shouyin.addItemListener(this);// 添加了事件监听
            jrb_shouyin.setPreferredSize(new Dimension(107, 45));
            jrb_shouyin.setBorderPainted(true);// 添加了边框
            group.add(jrb_shouyin);
            jp_west.add(jrb_shouyin);


            jrb_yonghu = new JRadioButton();
            jrb_yonghu.setIcon(new ImageIcon("src/images/yonghu.jpg"));
            jrb_yonghu.addItemListener(this);// 添加了事件监听
            jrb_yonghu.setPreferredSize(new Dimension(107, 45));
            jrb_yonghu.setBorderPainted(true);
            group.add(jrb_yonghu);
            jp_west.add(jrb_yonghu);


            jrb_huiyuan = new JRadioButton();
            jrb_huiyuan.setIcon(new ImageIcon("src/images/huiyuan.jpg"));
            jrb_huiyuan.addItemListener(this);// 添加了事件监听
            jrb_huiyuan.setPreferredSize(new Dimension(107, 45));
            jrb_huiyuan.setBorderPainted(true);
            group.add(jrb_huiyuan);
            jp_west.add(jrb_huiyuan);
            con.add(jp_west, BorderLayout.WEST);

//            jrb_huiyuan = new JRadioButton();
//            jrb_huiyuan.setIcon(new ImageIcon("src/images/huiyuan.jpg"));
//            jrb_huiyuan.setPreferredSize(new Dimension(107, 45));
//            jrb_huiyuan.setBorderPainted(true);
//
//            // 事件处理的第二种方式：匿名内部类
//            // new ItemListener(){
//            //
//            //            } 省略掉了实现类
//            jrb_huiyuan.addActionListener(new ItemListener(){
//
//                @Override
//                public void itemStateChanged(ItemEvent e) {
//                    // 不需要判断事件源
//                    // 直接写会员单选按钮所做的事
//                    if(jrb_huiyuan.isSelected()){
//                        System.out.println("进入会员界面");
//                    }
//                }
//            });
//
//            group.add(jrb_huiyuan);
//            jp_west.add(jrb_huiyuan);


            jrb_leibie = new JRadioButton();
            jrb_leibie.setIcon(new ImageIcon("src/images/leibie.jpg"));
            jrb_leibie.addItemListener(this);// 添加了事件监听
            jrb_leibie.setPreferredSize(new Dimension(107, 45));
            jrb_leibie.setBorderPainted(true);
            group.add(jrb_leibie);
            jp_west.add(jrb_leibie);


            jrb_danwei = new JRadioButton();
            jrb_danwei.setIcon(new ImageIcon("src/images/danwei.jpg"));
            jrb_danwei.addItemListener(this);// 添加了事件监听
            jrb_danwei.setPreferredSize(new Dimension(107, 45));
            jrb_danwei.setBorderPainted(true);
            group.add(jrb_danwei);
            jp_west.add(jrb_danwei);


            jrb_jinhuo = new JRadioButton();
            jrb_jinhuo.setIcon(new ImageIcon("src/images/jinhuo.jpg"));
            jrb_jinhuo.addItemListener(this);// 添加了事件监听
            jrb_jinhuo.setPreferredSize(new Dimension(107, 45));
            jrb_jinhuo.setBorderPainted(true);
            group.add(jrb_jinhuo);
            jp_west.add(jrb_jinhuo);


            jrb_shangpin = new JRadioButton();
            jrb_shangpin.setIcon(new ImageIcon("src/images/shangpin.jpg"));
            jrb_shangpin.addItemListener(this);// 添加了事件监听
            jrb_shangpin.setPreferredSize(new Dimension(107, 45));
            jrb_shangpin.setBorderPainted(true);
            group.add(jrb_shangpin);
            jp_west.add(jrb_shangpin);


//            jrb_yingye = new JRadioButton();
//            jrb_yingye.setIcon(new ImageIcon("src/images/yingye.jpg"));
//            jrb_yingye.addItemListener(this);// 添加了事件监听
//            jrb_yingye.setPreferredSize(new Dimension(107, 45));
//            jrb_yingye.setBorderPainted(true);
//            group.add(jrb_yingye);
//            jp_west.add(jrb_yingye);


            jrb_gonghuo = new JRadioButton();
            jrb_gonghuo.setIcon(new ImageIcon("src/images/gonghuo.jpg"));
            jrb_gonghuo.addItemListener(this);// 添加了事件监听
            jrb_gonghuo.setPreferredSize(new Dimension(107, 45));
            jrb_gonghuo.setBorderPainted(true);
            group.add(jrb_gonghuo);
            jp_west.add(jrb_gonghuo);


            jrb_guanyu = new JRadioButton();
            jrb_guanyu.setIcon(new ImageIcon("src/images/guanyu.jpg"));
            jrb_guanyu.addItemListener(this);// 添加了事件监听
            jrb_guanyu.setPreferredSize(new Dimension(107, 45));
            jrb_guanyu.setBorderPainted(true);
            group.add(jrb_guanyu);
            jp_west.add(jrb_guanyu);


            con.add(jp_west, BorderLayout.WEST);
        }

        // 中间的盒子 卡片布局(根据左侧，显示不同的卡片)
        // 卡片布局的特点： 按顺序叠放多个卡片（jpanel），每个jpanel对应一个功能页面

        {
            jp_center = new JPanel();// 中间的整体的小箱子，使用卡片布局，默认是流式布局
            // 创建卡片布局对象
            cardLayout = new CardLayout();
            // 给jp_center设置卡片布局
            jp_center.setLayout(cardLayout);

            // 创建卡片
            YongHuJpanel jp_yonghu  = new YongHuJpanel();
            GuanYuJPanel jp_guanyu = new GuanYuJPanel();
            HuiYuanJpanel jp_huiyuan = new HuiYuanJpanel();
            GongHuoJpanel jp_gonghuo = new GongHuoJpanel();
            JinHuoJPanel jp_jinhuo  = new JinHuoJPanel();
            ShouYinJPanel jp_shouyin = new ShouYinJPanel();
            LeibieJpanel jp_leibie = new LeibieJpanel();
            ShangPinDanWeiJPanel jp_shangpin = new ShangPinDanWeiJPanel();
            ShangPinJPanel jp_shangpin1 = new ShangPinJPanel();

            // 将卡片放入中间的箱子
            jp_center.add("yonghu",jp_yonghu);
            jp_center.add("huiyuan", jp_huiyuan);
            jp_center.add("jinhuo",jp_jinhuo);
            jp_center.add("guanyu", jp_guanyu);
            jp_center.add("gonghuo",jp_gonghuo);
            jp_center.add("shouyin",jp_shouyin);
            jp_center.add("leibie",jp_leibie);
            jp_center.add("danwei",jp_shangpin);
            jp_center.add("shangpin",jp_shangpin1);


            // 将最后一张卡片放到最前面
            cardLayout.last(jp_center);

            con.add(jp_center, BorderLayout.CENTER);
        }


    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        // 判断当前是哪个单选按钮被选中
        Object source = e.getSource();
        if (source == jrb_shouyin) {
            if (jrb_shouyin.isSelected()) {

                cardLayout.show(jp_center,"shouyin" );

            }
        }
        if (source == jrb_yonghu) {
            if (jrb_yonghu.isSelected()) {

                cardLayout.show(jp_center,"yonghu");
            }
        }
        if (source == jrb_huiyuan) {
            if (jrb_huiyuan.isSelected()) {

                cardLayout.show(jp_center,"huiyuan");
            }
        }
        if (source == jrb_leibie) {
            if (jrb_leibie.isSelected()) {

                cardLayout.show(jp_center,"leibie");
            }
        }
        if (source == jrb_danwei) {
            if (jrb_danwei.isSelected()) {

                cardLayout.show(jp_center,"danwei");
            }
        }
        if (source == jrb_jinhuo) {
            if (jrb_jinhuo.isSelected()) {

                cardLayout.show(jp_center,"jinhuo" );
            }
        }
        if (source == jrb_shangpin) {
            if (jrb_shangpin.isSelected()) {

                cardLayout.show(jp_center,"shangpin");
            }
        }
        if (source == jrb_yingye) {
            if (jrb_yingye.isSelected()) {

                cardLayout.show(jp_center,"yingye");
            }
        }
        if (source == jrb_gonghuo) {
            if (jrb_gonghuo.isSelected()) {

                cardLayout.show(jp_center,"gonghuo");
            }
        }
        if (source == jrb_guanyu) {
            if (jrb_guanyu.isSelected()) {

                cardLayout.show(jp_center,"guanyu");
            }
        }
    }
}
