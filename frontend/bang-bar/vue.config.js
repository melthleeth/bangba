module.exports = {
  devServer: {
    overlay:false
  },
    configureWebpack: {
      module: {
        rules: [
          {
            test: /\.css$/,
            use: ['postcss-loader']
          }
        ]
      }
  }
  
  }