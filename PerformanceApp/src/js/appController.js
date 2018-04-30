/**
 * @license
 * Copyright (c) 2014, 2018, Oracle and/or its affiliates.
 * The Universal Permissive License (UPL), Version 1.0
 */
/*
 * Your application specific code will go here
 */
define(['ojs/ojcore', 'knockout', 'ojs/ojmodule-element-utils', 'ojs/ojmodule-element', 'ojs/ojrouter', 'ojs/ojknockout', 'ojs/ojarraytabledatasource'],
  function(oj, ko, moduleUtils) {
     function ControllerViewModel() {
       var self = this;

      // Media queries for repsonsive layouts
      var smQuery = oj.ResponsiveUtils.getFrameworkQuery(oj.ResponsiveUtils.FRAMEWORK_QUERY_KEY.SM_ONLY);
      self.smScreen = oj.ResponsiveKnockoutUtils.createMediaQueryObservable(smQuery);

       // Router setup
       self.router = oj.Router.rootInstance;
       self.router.configure({
         'create': {label: 'Create new Account', isDefault: true},
         'update': {label: 'Update Employee Info'},
         'performance': {label: 'New Performance'},
         'average': {label: 'Average Performance'}
       });
      oj.Router.defaults['urlAdapter'] = new oj.Router.urlParamAdapter();

      self.moduleConfig = ko.observable({'view':[], 'viewModel':null});

      self.loadModule = function() {
        ko.computed(function() {
          var name = self.router.moduleConfig.name();
          var viewPath = 'views/' + name + '.html';
          var modelPath = 'viewModels/' + name;
          var masterPromise = Promise.all([
            moduleUtils.createView({'viewPath':viewPath}),
            moduleUtils.createViewModel({'viewModelPath':modelPath})
          ]);
          masterPromise.then(
            function(values){ 
              self.moduleConfig({'view':values[0],'viewModel':values[1]}); 
            },
            function(reason){}
          );
        });
      };

      // Navigation setup
      var navData = [
      {name: 'Create new Account', id: 'create',
       iconClass: 'oj-navigationlist-item-icon demo-icon-font-24 demo-chart-icon-24'},
      {name: 'Update Employee Info', id: 'update',
       iconClass: 'oj-navigationlist-item-icon demo-icon-font-24 demo-fire-icon-24'},
      {name: 'New Performance', id: 'performance',
       iconClass: 'oj-navigationlist-item-icon demo-icon-font-24 demo-people-icon-24'},
      {name: 'Average Performance', id: 'average',
       iconClass: 'oj-navigationlist-item-icon demo-icon-font-24 demo-info-icon-24'}
      ];
      self.navDataSource = new oj.ArrayTableDataSource(navData, {idAttribute: 'id'});

      // Header
      // Application Name used in Branding Area
      self.appName = ko.observable("Performance Managment");
      // User Info used in Global Navigation area
      self.userLogin = ko.observable("");

      // Footer
      function footerLink(name, id, linkTarget) {
        this.name = name;
        this.linkId = id;
        this.linkTarget = linkTarget;
      }
     }

     return new ControllerViewModel();
  }
);
